package misc;

import java.util.ArrayList;

public class AllPrimesNumbersInGivenRange {
	 static ArrayList<Integer> sieveOfEratosthenes(int M, int N) {
		 ArrayList<Integer> primes = new ArrayList<>();
	        primes.add(2);
	        for(int i=3;i<=N;i+=2){
	            primes.add(i);
	        }
	        int i=1;
	        int n=primes.size();
	        while(true){
	            if(i >= n) break;
	            int temp=primes.get(i);
	            for(int j=(temp*temp)/2;j<n && j>=0;j+=temp){
	                primes.set(j,0);
	            }
	            i+=1;
	            while(i<n){
	                if(primes.get(i) != 0) break;
	                i++;
	            }
	        }
	        while(n > 0 && primes.get(0) < M){
	            primes.remove(0);
	            n--;
	        }
	        i=0;
	        while(i<n){
	            if(primes.get(i) == 0){
	                primes.remove(i);
	                n--;
	            }
	            else i++;
	        }
	        return primes;
	 }
	 public static void main(String[] args) {
		 ArrayList<Integer> primes = sieveOfEratosthenes(91,95);
		 for(int i:primes) {
			 System.out.print(i);
		 }
	 }
}
