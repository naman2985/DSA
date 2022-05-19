/*
 * Given n petrol pumps in a circular path with a given amount of petrol at each pump.
 * Each unit of fuel helps you drive one unit distance. Each adjacent petrol pump has some distance seperating them.
 * You start with an empty fuel and must complete one circle around the path containing the petrol pumps.
 * Find the fuel station from where you must start to complete a round. It is given that there is only one way to do it.
 */

package queue;
public class CircularTour {
	static int startIndex(int[] fuel,int[] dist,int n) {
		int start = 0,end = 1,curr_petrol = fuel[start] - dist[start];
		while(end!= start||curr_petrol < 0) {
			while(curr_petrol < 0 && start!=end) {
				curr_petrol -= fuel[start] - dist[start];
				start = (start + 1)%n;
				if(start == 0) return -1;
			}
			curr_petrol += fuel[end] - dist[end];
			end = (end + 1) % n;
		}
		return start;
	}
	
	static int startIndexIteratingFromBackwards(int[] fuel,int[] dist,int n) {
		int max = fuel[n-1] - dist[n-1],curr = max,max_id = n-1;
		for(int i=n-2;i>=0;i--) {
			curr = curr + fuel[i] - dist[i];
			if(max < curr) {
				max = curr;
				max_id = i;
			}
		}
		if(curr>=0)
			return max_id;
		return -1;
	}
	
	public static void main(String[] args) {
		int[] fuel = {6,3,7},dist= {4,6,6};
		System.out.println(startIndex(fuel,dist,3));
		System.out.println(startIndexIteratingFromBackwards(fuel, dist, 3));
	}
}
