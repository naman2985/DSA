package array;
import java.util.*;
public class TopKFrequentElementsInArray {
	public static List<Map.Entry<Integer, Integer>> sortByValue(HashMap<Integer, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Integer>> list =
               new LinkedList<Map.Entry<Integer, Integer> >(hm.entrySet());
 
        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2)
            {
                return o2.getKey() - o1.getKey();
            }
        });
        
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2)
            {
                return o2.getValue() - o1.getValue();
            }
        });
        
        return list;
    }
    
    public static int[] topK(int[] nums, int k) {
        // Code here
        int kMostFrequent[] = new int[k];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            if(map.containsKey(i)){
                int value = map.get(i);
                map.put(i,value + 1);
            }
            else map.put(i, 1);
        }
        int i = 0;
                    
        List<Map.Entry<Integer, Integer>> list = sortByValue(map);
        for(Map.Entry<Integer, Integer> a : list){
            if(i >= k) break;
            kMostFrequent[i++] = a.getKey();
        }
        return kMostFrequent;
    }
}
