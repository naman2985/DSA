package backtracking;

import java.util.ArrayList;
/*
 *  Given a 2D array of size n*n with 0s and 1s,
 *  0 means wall and 1 means unblocked space,
 *  find all the paths from (0,0) to (n-1,n-1),
 *  without ever revisiting a cell in any path. 
 */
public class RatMazeProblem {
	static void findPaths(int m[][], int n, int i, int j, String path, boolean visited[][], ArrayList<String> paths){
        if(i < 0 || j < 0 || i >= n || j >= n) return;
        if(m[i][j] == 0 || visited[i][j]) return;
        if(i == n-1 && j == n-1){
            paths.add(path);
            return;
        }
        visited[i][j] = true;
        findPaths(m,n,i+1,j,path+"D",visited,paths);
        findPaths(m,n,i,j+1,path+"R",visited,paths);
        findPaths(m,n,i-1,j,path+"U",visited,paths);
        findPaths(m,n,i,j-1,path+"L",visited,paths);
        visited[i][j] = false;
    }
    
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> paths = new ArrayList<>();
        boolean visited[][] = new boolean[n][n];
        findPaths(m, n, 0, 0, "",visited, paths);
        return paths;
    }
}
