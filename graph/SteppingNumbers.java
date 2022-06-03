package graph;

import java.util.LinkedList;
import java.util.Queue;

/* A number is called a stepping number if all adjacent digits have an absolute difference of 1,
 *  e.g. '321' is a Stepping Number while 421 is not. 
 *  Given two integers n and m, find the count of all the stepping numbers in the range [n, m].
 */
public class SteppingNumbers {
	int steppingNumbers(int n, int m){
        int count=0;
        if(n==0) count++;
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<10;i++){
            q.add(i);
        }
        while(!q.isEmpty()){
            int temp=q.poll(),rem=temp%10;
            if(temp>m) break;
            if(temp<=m && temp>=n){
                count++;
            }
            int res=0;
            if(rem != 9){
                res=temp*10+rem+1;
                if(res<=m) q.add(res);
            }
            if(rem!=0){
                res=temp*10+rem-1;
                if(res<=m) q.add(res);
            }
        }
        return count;
    }
}
