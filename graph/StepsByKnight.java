package graph;
// A knight is placed at a given position on a chess board
// What is the minimum number of steps a knight would take to reach a target position.
import java.util.*;
public class StepsByKnight {
	static int[][] moves = {{1,2},{2,1},{1,-2},{2,-1},{-1,2},{-2,1},{-1,-2},{-2,-1}};
    static int[] add(int a[],int b[]){
        int[] c = {a[0]+b[0],a[1]+b[1]};
        return c;
    }
    static boolean isValid(int a[],int N){
        if(a[0]<1 || a[0]>N || a[1] <1 || a[1]>N) return false;
        return true;
    }
    static public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        if(N==2 || (N==3 && KnightPos[0] == 2 && KnightPos[1] == 2)) return -1;
        Queue<int[]> q = new LinkedList<>();
        int steps=0;
        boolean visited[][]=new boolean[N][N];
        q.add(KnightPos);
        visited[KnightPos[0]-1][KnightPos[1]-1]=true;
        while(!q.isEmpty()){
            int n=q.size();
            System.out.println(n);
            while(n-->0){
                int mat[]=q.poll();
                System.out.println(mat[0] + " " + mat[1] + " " + steps + " " + n);
                if(Arrays.equals(mat,TargetPos)) {
                    return steps;
                }
                for(int i=0;i<8;i++){
                    int temp[]=add(mat,moves[i]);
                    if(isValid(temp,N) && !visited[temp[0]-1][temp[1]-1]){
                        q.add(temp);
                        visited[temp[0]-1][temp[1]-1]=true;
                    }
                }
            }
            steps++;
        }
        return steps;
    }
    public static void main(String[] args) {
    	int[] kp= {4,5},tp= {1,1};
		System.out.println(minStepToReachTarget(kp,tp,6));
	}
}
