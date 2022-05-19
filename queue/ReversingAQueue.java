package queue;

import java.util.*;

public class ReversingAQueue {
	static Queue<Integer> reverseQueue(Queue<Integer> q) {
		if(q.isEmpty()) return null;
		if(q.size() == 1) {
			return q;
		}
		int ret = q.poll();
		q = reverseQueue(q);
		q.add(ret);
		return q;
	}
	
	public static void main(String args[]) {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		q = reverseQueue(q);
		while(!q.isEmpty()) System.out.println(q.poll());
	}
}
