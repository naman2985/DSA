/*
 * Given a number, find the lowest multiple of that number made of only digits 0 and 9
 */

package queue;
import java.util.*;
public class SmallestMultipleOfAGivenNumber {
	static int MAX_COUNT = 10000;
	static List<String> vec = new LinkedList<String>();
	static void generateNumbersUtil() {
		Queue<String> q = new LinkedList<String>();
		q.add("9");
		for(int count=MAX_COUNT;count>0;count--) {
			String s1 = q.poll();
			vec.add(s1);
			q.add(s1 + "0");
			q.add(s1 + "9");
		}
	}
	static String findSmallestMultiple(int n) {
		for(int i=0;i<vec.size();i++) {
			if(Integer.parseInt(vec.get(i))%n == 0)
				return vec.get(i);
		}
		return "";
	}
	public static void main(String[] args) {
		generateNumbersUtil();
		for(int i=1;i<100;i++) {
			System.out.println(findSmallestMultiple(i));
		}
	}
}
