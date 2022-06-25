package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
	static ArrayList<ArrayList<Integer>> neighbors(ArrayList<Integer> cell,boolean visit[][],int m,int n){
        ArrayList<ArrayList<Integer>> neigh=new ArrayList<>();
        int i=cell.get(0),j=cell.get(1);
        if(i>0&&!visit[i-1][j]) neigh.add(new ArrayList<>(Arrays.asList(i-1,j)));
        if(i<m-1&&!visit[i+1][j]) neigh.add(new ArrayList<>(Arrays.asList(i+1,j)));
        if(j>0&&!visit[i][j-1]) neigh.add(new ArrayList<>(Arrays.asList(i,j-1)));
        if(j<n-1&&!visit[i][j+1]) neigh.add(new ArrayList<>(Arrays.asList(i,j+1)));
        if(i>0&&j>0&&!visit[i-1][j-1]) neigh.add(new ArrayList<>(Arrays.asList(i-1,j-1)));
        if(i>0 && j<n-1 && !visit[i-1][j+1]) neigh.add(new ArrayList<>(Arrays.asList(i-1,j+1)));
        if(i<m-1 && j>0 && !visit[i+1][j-1]) neigh.add(new ArrayList<>(Arrays.asList(i+1,j-1)));
        if(i<m-1 && j<n-1 && !visit[i+1][j+1]) neigh.add(new ArrayList<>(Arrays.asList(i+1,j+1)));
        return neigh;
    }
    public static int numIslands(char[][] grid) {
        // Code here
        int m=grid.length,n=grid[0].length,numIslands=0;
        boolean visit[][]=new boolean[m][n];
        Queue<ArrayList<Integer>> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visit[i][j]){
                    visit[i][j]=true;
                    if(grid[i][j]=='1'){
                        q.add(new ArrayList<>(Arrays.asList(i,j)));
                        while(!q.isEmpty()){
                            ArrayList<Integer> cell=q.poll();
                            ArrayList<ArrayList<Integer>> neigh=neighbors(cell,visit,m,n);
                            for(ArrayList<Integer> c:neigh){
                                visit[c.get(0)][c.get(1)]=true;
                                if(grid[c.get(0)][c.get(1)]=='1')
                                    q.add(c);
                            }
                        }
                        numIslands++;
                    }
                }
            }
        }
        return numIslands;
    }
}
