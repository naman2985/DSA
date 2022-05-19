/*
 * Given a queue consisting first n natural numbers(in random order) - find if the queue can be sorted increasing order in another queue.
 */

package queue;
import java.util.*;

public class CheckIfAQueueCanBeSorted {
	public static boolean canBeSorted(Queue<Integer> queue) {
		Stack<Integer> st = new Stack<>();
		int expected = 1;
		while(!queue.isEmpty()) {
			if(!st.empty() && st.peek() == expected) {
				st.pop();
				expected++;
			}
			else if(queue.peek() == expected) {
				queue.poll();
				expected++;
			}
			else {
				if(!st.empty() && st.peek() < queue.peek()) return false;
				st.push(queue.poll());
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		q.add(4);
		q.add(3);
		q.add(2);
		q.add(5);
		//1 4 3 2 5
		System.out.println(canBeSorted(q));
		q.clear();
		q.add(2);
		q.add(3);
		q.add(1);
		//2 3 1
		System.out.println(canBeSorted(q));
	}
}
