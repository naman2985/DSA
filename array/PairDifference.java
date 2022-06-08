import java.lang.Math;
import java.util.HashMap;
public class PairDifference {
	static int pairDiff(int[] arr,int d){
		int count=0;
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i:arr){
			count+=(map.containsKey(i+d)?map.get(i+d):0)+(map.containsKey(i-d)?map.get(i-d):0);
			map.put(i,(map.containsKey(i)?map.get(i):0)+1);
		}
		System.out.println(count);
		return count;
	}
	public static void main(String[] args) {
		int arr[]={0, -1, 2, -3, 1};
		pairDiff(arr,2);
	}
}