package array;
import java.util.*;
public class SparseArray {
	static int[] sparseArray(String[] s,String[] q) {
		HashMap<String,Integer> map = new HashMap<>();
		int n1=s.length,n2=q.length,arr[]=new int[n2];
		for(int i=0;i<n1;i++) {
			if(map.containsKey(s[i])) {
				map.put(s[i],map.get(s[i])+1);
			}
			else map.put(s[i], 1);
		}
		for(int i=0;i<n2;i++) {
			if(map.containsKey(q[i])) arr[i]=map.get(s[i]);
			else arr[i]=0;
		}
		return arr;
	}
	public static void main(String[] args) {
		String[] s= {"abc","bc","cd","ef"},q= {"abc","abc","cd","ef","gh"};
		int arr[] = sparseArray(q, s);
		for(int i:arr) {
			System.out.print(i+" ");
		}
	}
}
