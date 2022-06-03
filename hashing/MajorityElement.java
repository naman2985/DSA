package hashing;
import java.util.HashMap;
public class MajorityElement {
	static void majorityElement(int[] arr) {
		HashMap<Integer,Integer> count = new HashMap<>();
		int n=arr.length;
		for(int i:arr) {
			try {
				int c=count.get(i);
				++c;
				if(c > n/2) {
					System.out.println("Majority element:" + i);
					return;
				}
				count.put(i, c);
			}
			catch(NullPointerException e){
				count.put(i, 1);
			}
		}
		System.out.println("No majority element");
	}
	public static void main(String[] args) {
		int a1[]={3, 3, 4, 2, 4, 4, 2, 4, 4};
		int a2[]={3, 3, 4, 2, 4, 4, 2, 4};
		majorityElement(a1);
		majorityElement(a2);
	}
}
