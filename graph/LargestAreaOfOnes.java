package graph;

import java.util.LinkedList;
import java.util.Queue;
// Given a 2-D matrix, find the largest consecutive area covered by cells with value 1.
// Two or more cells containing 1's form an area if all the cells are adjacent to at-least one other cell in the same area
// either in a straight line or diagonally
public class LargestAreaOfOnes {
	static int neighbor[][]={{0,1},{1,0},{0,-1},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
    static int[] add(int[] a,int[] b){
        int[] c=new int[2];
        c[0]=a[0]+b[0];
        c[1]=a[1]+b[1];
        return c;
    }
    static boolean isValid(int[] cell,int m,int n){
        if(cell[0]>=m || cell[0]<0 || cell[1]>=n || cell[1]<0) return false;
        return true;
    }
    public int findMaxArea(int[][] grid)
    {
        // Code here
        int m=grid.length,n=grid[0].length,max=0,x=0,y=0,curr=0;
        boolean visit[][]=new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        while(true){
            if(q.isEmpty()){
            for(;x<m;x++){
                boolean f=false;
                for(;y<n;y++){
                    if(!visit[x][y] && grid[x][y]==1){
                        q.add(new int[]{x,y});
                        visit[x][y]=true;
                        f=true;
                        break;
                    }
                }
                if(f){
                    max=Math.max(max,curr);
                    curr=0;
                    break;
                }
                y=0;
            }}
            if(q.isEmpty()) break;
            int[] cell = q.poll();
            curr++;
            for(int i=0;i<8;i++){
                int[] temp=add(cell,neighbor[i]);
                if(isValid(temp,m,n) && grid[temp[0]][temp[1]]==1 && !visit[temp[0]][temp[1]]){
                    q.add(temp);
                    visit[temp[0]][temp[1]]=true;
                }
            }
        }
        max=Math.max(curr,max);
        return max;
    }
}
