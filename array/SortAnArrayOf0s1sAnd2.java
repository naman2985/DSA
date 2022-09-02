package array;

public class SortAnArrayOf0s1sAnd2 {
	public static void sort012(int a[], int n)
    {
        // code here 
        int zeroes = 0, ones = 0;
        for(int i:a){
            if(i == 0) zeroes += 1;
            else if(i == 1) ones += 1;
        }
        for(int i=0;i<n;i++){
            if(i < zeroes) a[i] = 0;
            else if(i < zeroes + ones) a[i] = 1;
            else a[i] = 2;
        }
    }
}
