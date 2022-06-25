package array;

import java.util.HashMap;

/*
 * You are given an array of positive integers. The score is defined as the sum of elements of subarray containing unique elements.
 * Return the maximum score you can get from one subarray.
 */
public class MaximumErasureValue {
	public static int maximumUniqueSubarray(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n=arr.length,j=0,score=0,maxScore=0;
        for(int i=0;i<n;i++){
            if(map.containsKey(arr[i])){
                while(arr[j++]!=arr[i]){
                    score-=arr[j-1];
                    map.remove(arr[j-1]);
                }
            }
            else score+=arr[i];
            maxScore=Math.max(score,maxScore);
            map.put(arr[i],1);
        }
        return maxScore;
    }
}
