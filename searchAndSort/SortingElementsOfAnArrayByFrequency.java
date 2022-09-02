package searchAndSort;
import java.util.*;
public class SortingElementsOfAnArrayByFrequency {
	private static List<Map.Entry<Integer, Integer>> sortByValue(HashMap<Integer, Integer> hm){
        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Integer> > list =
               new LinkedList<Map.Entry<Integer, Integer> >(hm.entrySet());
 
        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2)
            {
                if(o1.getValue() != o2.getValue())
                    return (o2.getValue()).compareTo(o1.getValue());
                return o1.getKey() - o2.getKey();
            }
        });
         
        return list;
    }
    
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    HashMap<Integer,Integer> map = new HashMap<>();
		    for(int i=0;i<n;i++){
		        arr[i] = sc.nextInt();
		        if(!map.containsKey(arr[i])) map.put(arr[i], 1);
		        else{
		            int value = map.get(arr[i]);
		            map.put(arr[i], value+1);
		        }
		    }
		    List<Map.Entry<Integer, Integer>> list = sortByValue(map);
		    
		    for(Map.Entry<Integer, Integer> entry:list){
		        for(int i=0;i<entry.getValue();i++) System.out.print(entry.getKey() + " ");
		    }
		    System.out.println();
		}
		sc.close();
	}
}
