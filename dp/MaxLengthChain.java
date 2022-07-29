package dp;

import java.util.*;

class Pair
{
    int x;
    int y;
     
    public Pair(int a, int b)
    {
        this.x = a;
        this.y = b;
    }
}

class CompareByFirst implements Comparator<Pair>
{
   public int compare(Pair a, Pair b)
    {
        return a.x - b.x;
    }
}

public class MaxLengthChain {
	int maxChainLength(Pair arr[], int n)
    {
       int longestChain[]=new int[n];
       Arrays.fill(longestChain,1);
       Arrays.sort(arr,new CompareByFirst());
       for(int i=1;i<n;i++){
           for(int j=0;j<i;j++){
               if(arr[j].y<arr[i].x){
                   longestChain[i] = Math.max(longestChain[i],longestChain[j]+1);
               }
           }
       }
       int max=0;
       for(int i:longestChain) max=Math.max(max,i);
       return max;
    }
}
