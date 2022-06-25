package graph;
import java.util.*;
/*
 * Given a dictionary, and two words ‘start’ and ‘target’ (both of same length). 
 * Find length of the smallest chain from ‘start’ to ‘target’ if it exists, 
 * such that adjacent words in the chain only differ by one character and 
 * each word in the chain is a valid word i.e., it exists in the dictionary. 
 * It may be assumed that the ‘target’ word exists in dictionary and length of all dictionary words is same. 
 */
public class WordLadder {
	static boolean areConnected(String s1,String s2,int n) {
		int diff=0;
		for(int i=0;i<n;i++) {
			if(s1.charAt(i)!=s2.charAt(i)) diff++;
			if(diff>1) return false;
		}
		if(diff==1) return true;
		return false;
	}
	static int bfs(int start,int target,ArrayList<ArrayList<Integer>> adj) {
		Queue<Integer> q=new LinkedList<>();
		boolean visit[]=new boolean[adj.size()];
		int steps=1;
		q.add(start);
		visit[start]=true;
		while(!q.isEmpty()) {
			int n=q.size(),id=q.poll();
			steps++;
			for(int j=0;j<n;j++) {
				for(int i:adj.get(id)) {
					if(!visit[i]) {
						if(i==target) return steps;
						visit[i]=true;
						q.add(i);
					}
				}
			}
		}
		return -1;
	}
	static int shortestChain(String[] dict,String start,String target) {
		if(start.equals(target)) return 0;
		int n=dict.length,l=dict[0].length(),s=0,t=0;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for(int i=0;i<n;i++) {
			adj.add(new ArrayList<>());
			if(dict[i].equals(start)) s=i;
			else if(dict[i].equals(target)) t=i;
			for(int j=0;j<n;j++) {
				if(areConnected(dict[i],dict[j],l))
					adj.get(i).add(j);
			}
		}
		return bfs(s,t,adj);
	}
	public static void main(String[] args) {
		String dict[]={"TOON","POON", "PLEE", "SAME", "POIE", "PLEA", "PLIE", "POIN"};
		System.out.println(shortestChain(dict,"TOON","PLEA"));
	}
}
