package array;

public class ArrangingTheArray {
	static void rotate(long arr[],int i,int j){
        long temp = arr[j];
        for(int x=j;x>i;x--)
            arr[x] = arr[x-1];
        arr[i] = temp;
    }
    
    public static void rearrange(long a[], long n){
        // Your code goes here
        int pos = 0;
        for(int i=0;i<n;i++){
            if(a[i] < 0){
                rotate(a,pos,i);
                pos++;
            }
        }
    }
}
