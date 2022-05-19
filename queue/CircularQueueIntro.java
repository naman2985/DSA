package queue;

public class CircularQueueIntro {
	private int []queue;
	private int start,end,max_size,size;
	public CircularQueueIntro(int n) {
		max_size = n;
		queue = new int[n];
		start = -1;
		end = -1;
		size = 0;
	}
	
	public boolean isFull() {
		return size == max_size; 
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void insert(int n) {
		if(!isFull()) {
			if(isEmpty()) {
				start++;
			}
			if(end == max_size-1) end = -1;
			queue[++end] = n;
			size++;
		}
		else System.out.println("Queue is already full");
	}
	
	public void delete() {
		if(isEmpty()) System.out.println("Queue is already empty");
		else {
			size--;
			if(isEmpty()) {
				start--;
				end--;
			}
			else {
				start += 1;
			}
		}
	}
	
	public int getFront() {
		if(isEmpty()) return Integer.MIN_VALUE;
		return queue[start];
	}
	
	public int getRear() {
		if(isEmpty()) return Integer.MAX_VALUE;
		return queue[end];
	}
	
	public static void main(String[] args) {
		CircularQueueIntro cq = new CircularQueueIntro(4);
		cq.insert(1);
		cq.insert(2);
		cq.insert(3);
		cq.insert(4);
		System.out.println(cq.getFront());
		System.out.println(cq.getRear());
		cq.delete();
		cq.insert(5);
		System.out.println(cq.getRear());
	}
}
