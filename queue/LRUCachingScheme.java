/*
 * Given a cache size. Remove the least recently accessed frame when the cache is full and a new page is refernced which is not in the cache.
 */

package queue;
import java.util.*;

public class LRUCachingScheme {
	private Deque<Integer> dQ;
	private HashSet<Integer> hashSet;
	private final int CACHE_SIZE;
	public LRUCachingScheme(int capacity) {
		// TODO Auto-generated constructor stub
		dQ = new LinkedList<>();
		hashSet = new HashSet<>();
		CACHE_SIZE = capacity;
	}
	
	public void refer(int page) {
		if(!hashSet.contains(page)) {
			if(dQ.size()==CACHE_SIZE) {
				int last = dQ.removeLast();
				hashSet.remove(last);
			}
		}
		else dQ.remove(page);
		dQ.push(page);
		hashSet.add(page);
	}
	
	public void display() {
		Iterator<Integer> itr = dQ.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
	
	public static void main(String[] args) {
		LRUCachingScheme cache = new LRUCachingScheme(4);
		cache.refer(1);
		cache.refer(2);
		cache.refer(3);
		cache.refer(1);
		cache.refer(4);
		cache.refer(5);
		cache.refer(2);
		cache.refer(2);
		cache.refer(1);
		cache.display();
	}
}
