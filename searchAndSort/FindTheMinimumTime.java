package searchAndSort;

/*
 * Geek wants to scan N documents using two scanners. 
 * If S1 and S2 are the time taken by the scanner 1 and scanner 2 to scan a single document, 
 * find the minimum time required to scan all the N documents.
 */

public class FindTheMinimumTime {
	static int minTime(int S1, int S2, int N)
    {
        // code here
        if(S1>S2){
            int temp=S1;
            S1=S2;
            S2=temp;
        }
        int min=Integer.MAX_VALUE,t1=N,t2=0;
        while(t1>=t2){
            min=Math.min(min,Math.max(S1*t1,S2*t2));
            t1--;t2++;
        }
        return min;
    }
}
