package array;

import java.util.HashSet;
import java.util.Set;
/*
 * Given two arrays a[] and b[] of size n and m respectively. The task is to find union between these two arrays.
 */
public class UnionOfTwoArrays {
	public static int doUnion(int a[], int n, int b[], int m) 
    {
        //Your code here
        Set<Integer> set = new HashSet<>();
        for(int i:a) set.add(i);
        for(int j:b) set.add(j);
        return set.size();
    }
}
