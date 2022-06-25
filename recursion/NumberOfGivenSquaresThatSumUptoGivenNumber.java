package recursion;
/*
 * Given a number n and another number k. Print the number of ways the number 'n' can be represented as sum of 'k' non-zero squares.
 */

// to be done later
import java.lang.Math;
public class NumberOfGivenSquaresThatSumUptoGivenNumber {
	static boolean printSquares(int n,int k,int i) {
		if(n <= 0) return false;
		if(k == 1) {
			int sq = (int) Math.sqrt(k);
			if(sq * sq == n) {
				System.out.print(n + " ");
				return true;
			}
			return false;
		}
		do {
			if(printSquares(n-i*i,k-1,i)) {
				System.out.print(i*i + " ");
				return true;
			}
			i++;
		} while(i*i <= n/k);
		return false;
	}
	static void noOfWays(int n,int k) {
		for(int i=1;i*i<=n/k;i++)
			if(printSquares(n,k,i)) System.out.println();
	}
	public static void main(String[] args) {
		noOfWays(100,1);
	}
}
