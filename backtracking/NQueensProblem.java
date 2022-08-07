package backtracking;

import java.util.ArrayList;

public class NQueensProblem {
	static ArrayList<Integer> positions;
    static boolean occupied[];
    
    static boolean checkDiagonal(int i,int j,int n){
        // main diagonal - top left to bottom right
        int x = (j >= i)?0:i-j;
        for(int k=x;k<i;k++){
            if(positions.get(k)-k-1 == j-i)
                return false;
        }
        
        // other diagonal - top right to bottom left
        x = (i + j >= n)?(i+j-n+1):0;
        for(int k=x;k<i;k++){
            if(positions.get(k) + k - 1 == i + j)
                return false;
        }
        
        return true;
    }
    
	static void nQueenUtil(int n, int i, ArrayList<ArrayList<Integer>> positionsList){
        if(i == n){
            positionsList.add((ArrayList<Integer>)positions.clone());
            return;
        }
        
        for(int j=0;j<n;j++){
            if(!occupied[j] && checkDiagonal(i,j,n)){
                occupied[j] = true;
                positions.set(i, j+1);
                nQueenUtil(n,i+1,positionsList);
                occupied[j] = false;
            }
        }
    }
    
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        ArrayList<ArrayList<Integer>> positionsList = new ArrayList<>();
        positions = new ArrayList<>();
        for(int i=0;i<n;i++)
            positions.add(0);
        occupied = new boolean[n];
        nQueenUtil(n,0, positionsList);
        return positionsList;
    }
}
