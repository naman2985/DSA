/*
 * Given a matrix with 3 values 0,1,2 representing empty cell, fresh oranges and rotten oranges. What is the minimum to rot all the oranges.
 * A rotten orange at index [i,j] can rot fresh oranges at indices [i-1,j],[i+1,j],[i,j-1],[i,j+1]
 * If it is impossible to rot all oranges, return -1
 */


// Not working

package queue;
import java.util.*;

class Cell{
	public int x,y;
	Cell(int x,int y){
		this.x = x;
		this.y = y;
	}
}

public class MinimumTimeToRotAllOranges {
	static boolean isValid(int i,int j,int r,int c) {
		return i >= 0 && j >= 0 && i < r && j < c;
	}
	
	static boolean isDelim(Cell cell) {
		return cell.x == -1;
	}
	
	static boolean checkAll(int mat[][]) {
		for(int[] i:mat) {
			for(int j:i) {
				if(j == 1) return false;
			}
		}
		return true;
	}
	
	static int minTime(int[][] mat,int r,int c) {
		Queue<Cell> rot = new LinkedList<>();
		int ans = 0;
		Cell temp;
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(mat[i][j] == 2) rot.add(new Cell(i,j));
			}
		}
		while(!rot.isEmpty()) {
			boolean flag = false;
			while(!isDelim(rot.peek())) {
				temp = rot.poll();
				if(isValid(temp.x+1,temp.y,r,c) && mat[temp.x+1][temp.y] == 1) {
					if(!flag) {
						ans++;
						flag = true;
					}
					mat[temp.x+1][temp.y] = 2;
					temp.x++;
					rot.add(new Cell(temp.x,temp.y));
					temp.x--;
				}
				if(isValid(temp.x-1,temp.y,r,c) && mat[temp.x-1][temp.y] == 1) {
					if(!flag) {
						ans++;
						flag = true;
					}
					mat[temp.x-1][temp.y] = 2;
					temp.x--;
					rot.add(new Cell(temp.x,temp.y));
					temp.x++;
				}
				if(isValid(temp.x,temp.y+1,r,c) && mat[temp.x][temp.y+1] == 1) {
					if(!flag) {
						ans++;
						flag = true;
					}
					mat[temp.x][temp.y+1] = 2;
					temp.y++;
					rot.add(new Cell(temp.x,temp.y));
					temp.y--;
				}
				if(isValid(temp.x,temp.y-1,r,c) && mat[temp.x][temp.y-1] == 1) {
					if(!flag) {
						ans++;
						flag = true;
					}
					mat[temp.x][temp.y-1] = 2;
					temp.y--;
					rot.add(new Cell(temp.x,temp.y));
				}
			}
			rot.remove();
			if(!rot.isEmpty()) rot.add(new Cell(-1,-1));
		}
		return checkAll(mat)?ans:-1;
	}
	public static void main(String[] args) {
		int[][] mat1 = {
				{2,1,0,2,1},
				{0,0,1,2,1},
				{1,0,0,2,1}
		},mat2= {
				{2,1,0,2,1},
				{1,0,1,2,1},
				{1,0,0,2,1}
		};
		System.out.println(minTime(mat1,3,5));
		System.out.println(minTime(mat2,3,5));
	}
}
