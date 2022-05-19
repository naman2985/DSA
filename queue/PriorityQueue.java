package queue;

class item{
	int value;
	int priority;
}

public class PriorityQueue {
	item queue[];
	int size=-1;
	public PriorityQueue() {
		// TODO Auto-generated constructor stub
		queue = new item[10];
	}
	public PriorityQueue(int n) {
		queue = new item[n];
	}
	
	void enqueue(int value,int priority) {
		size++;
		if(queue[size]==null) queue[size] = new item();
		queue[size].value = value;
		queue[size].priority = priority;
	}
	
	public int peek() {
		int h = Integer.MIN_VALUE;
		int ind=-1;
		for(int i=0;i<=size;i++) {
			if(h==queue[i].priority && ind>-1 && queue[ind].value<queue[i].value) {
				ind = i;
			}
			else if(h<queue[i].priority) {
				h = queue[i].priority;
				ind = i;
			}
		}
		return ind;
	}
	
	public void dequeue() {
		int ind = peek();
		for(int i=ind;i<size;i++) {
			queue[i] = queue[i+1];
		}
		size--;
	}
	
	public static void main(String[] args) {
		PriorityQueue queue = new PriorityQueue(10);
		queue.enqueue(1, 0);
		queue.enqueue(2, 2);
		queue.enqueue(4, 1);
		System.out.println(queue.queue[queue.peek()].value);
		queue.dequeue();
		System.out.println(queue.queue[queue.peek()].value);
		queue.dequeue();
		System.out.println(queue.queue[queue.peek()].value);
	}
}
