/*
 * Given a stream of characters, print the first non-repeating character in the stream, each time a new character is read
 */

package queue;
import java.util.*;
public class FirstNonRepeatingCharacterInAStream {
	static void nonRepeating(String s) {
		Queue<Character> q = new LinkedList<>();
		Map<Character, Boolean> repeated = new HashMap<Character,Boolean>();
		int n = s.length();
		for(int i=0;i<n;i++) {
			if(repeated.containsKey(s.charAt(i))) repeated.put(s.charAt(i),true);
			else repeated.put(s.charAt(i), false);
			q.add(s.charAt(i));
			while(!q.isEmpty() && repeated.get(q.peek())) q.poll();
			if(q.isEmpty()) System.out.print(-1 + " ");
			else System.out.print(q.peek() + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		String s = "abaab";// a a b b -1
		nonRepeating(s);
	}
}
