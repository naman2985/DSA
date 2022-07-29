package array;

import java.util.HashMap;
import java.util.Stack;

// leetcode # 992
public class SubarraysWithKDifferentIntegers {
	public int subarraysWithKDistinct(int[] arr, int k) {
        int count = 0, n = arr.length;
        int start = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            int j = map.containsKey(arr[i])?map.get(arr[i])+1:1;
            map.put(arr[i],j);
            while(map.size() > k){
                j = map.get(arr[start]);
                if(j == 1) map.remove(arr[start]);
                else map.put(arr[start], j-1);
                start++;
            }
            while(map.size() == k){
                count++;// 1 2 3 4 5 6
                st.push(arr[start]);
                j = map.get(arr[start]);
                if(j == 1) map.remove(arr[start]);
                else map.put(arr[start],j-1);
                start++;
            }
            while(!st.isEmpty()){
                j = map.containsKey(st.peek())?map.get(st.peek()):0;
                map.put(st.pop(),j+1);
                start--;
            }
        }
        return count;
    }
}
