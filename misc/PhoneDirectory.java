package misc;

//leetcode # 379
import java.util.HashSet;

public class PhoneDirectory {
	private int size;
	private HashSet<Integer> numbers;
	PhoneDirectory(int n){
		size = n;
		numbers = new HashSet<>();
		for(int i=0;i<n;i++) numbers.add(i);
	}
	
	int get() {
		for(int i:numbers) return i;
		return -1;
	}
	
	boolean check(int n) {
		return numbers.contains(n);
	}
	
	void release(int n) {
		if(n < size)
			numbers.add(n);
	}
	
}
