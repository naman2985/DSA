/*
 * Deque is a queue that allows insertion and deletion at both end
 * Operations performed in a deque:
 * insertFront()
 * insertLast()
 * deleteFront()
 * deleteLast()
 * getFront()
 * getRear()
 * isEmpty()
 * isFull()
 */

package queue;

public class Dequeintro {
	private int queue[];
	private int start,end,max_size;
	public Dequeintro(int n) {
		queue = new int[n];
		max_size = n;
		start = n/2-1;
		end = n/2;
	}
	
	public void insertFront(int n) {
		if(!isFull()){
			queue[start] = n;
			start--;
		}
	}
	
	public void insertLast(int n) {
		if(!isFull()) {
			queue[end] = n;
			end++;
		}
	}
	
	public boolean isEmpty() {
		return end - start == 1;
	}
	
	public boolean isFull() {
		return start == 0 && end == max_size; 
	}
	
	public void deleteFront() {
		if(!isEmpty()) start++;
	}
	
	public void deleteLast() {
		if(!isEmpty()) end--;
	}
	
	public int getFront() {
		if(!isEmpty()) return queue[start+1];
		return Integer.MIN_VALUE;
	}
	
	public int getRear() {
		if(!isEmpty()) return queue[end-1];
		return Integer.MAX_VALUE;
	}
	
	public static void main(String[] args) {
		Dequeintro dq = new Dequeintro(10);
		dq.insertFront(1);
		dq.insertLast(4);
		dq.insertFront(9);
		dq.insertLast(8);
		// 9 1 4 8
		System.out.println(dq.getFront());//9
		dq.deleteFront();
		System.out.println(dq.getRear());//8
		System.out.println(dq.getFront());//1
		dq.deleteFront();
		dq.deleteLast();
		System.out.println(dq.getFront() == dq.getRear());
		dq.deleteFront();
		System.out.println(dq.getFront() + " " + dq.getRear());
	}
}
