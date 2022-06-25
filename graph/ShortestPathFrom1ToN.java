package graph;
/*
 * Consider a directed graph whose vertices are numbered from 1 to n.
 * There is an edge from a vertex i to a vertex j iff either j = i + 1 or j = 3 * i.
 * The task is to find the minimum number of edges in a path in G from vertex 1 to vertex n.
 */
public class ShortestPathFrom1ToN {
	static int minStep(int n){
        //complete the function here
        int steps=0;
        while(n!=1){
            if(n%3!=0) n-=1;
            else n/=3;
            steps++;
        }
        return steps;
    }
}
