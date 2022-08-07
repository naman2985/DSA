package backtracking;

import java.util.ArrayList;

public class SudokuSolver {
	static boolean row[][];
    static boolean col[][];
    static ArrayList<ArrayList<Integer>> moves;
    static boolean isValid(int grid[][],int i,int j,int num){
        // check in current 3*3 grid
        int x = 3*(i/3) + 3;
        int y = 3*(j/3) + 3;
        for(int m=x-3;m<x;m++){
            for(int n=y-3;n<y;n++){
                if(grid[m][n] == num)
                    return false;
            }
        }
        
        // for checking if the same number is present in current row or column
        return !(row[i][num-1] || col[j][num-1]);
    }
    
    static boolean solve(int grid[][],int i,int n){
        if(i == n) return true;
        int x = moves.get(i).get(0);
        int y = moves.get(i).get(1);
        for(int j=1;j<=9;j++){
            if(isValid(grid,x,y,j)){
                row[x][j-1] = true;
                col[y][j-1] = true;
                grid[x][y] = j;
                if(solve(grid,i+1,n)) return true;
                grid[x][y] = 0;
                row[x][j-1] = false;
                col[y][j-1] = false;
            }
        }
        return false;
    }
    
    static boolean SolveSudoku(int grid[][])
    {
        // add your code here
        row = new boolean[9][9];
        col = new boolean[9][9];
        moves = new ArrayList<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(grid[i][j] == 0){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    moves.add(temp);
                }
                else{
                    row[i][grid[i][j]-1] = true;
                    col[j][grid[i][j]-1] = true;
                }
            }
        }
        int n = moves.size();
        return solve(grid,0,n);
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        // add your code here
        for(int arr[]:grid){
            for(int i:arr){
                System.out.print(i + " ");
            }
        }
    }
}
