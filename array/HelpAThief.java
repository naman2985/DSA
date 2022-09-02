package array;

/*
 * You have to help a thief to steal as many as GoldCoins as possible from a GoldMine. 
 * There he saw N Gold Boxes an each Gold Boxes consists of Ai Plates each plates consists of Bi Gold Coins. 
 * Your task is to print the maximum gold coins theif can steal if he can take a maximum of T plates.
 */

public class HelpAThief {
	public static void quickSort(int a[],int b[], int low, int high)
    {
        // code here
        if(low < high){
            int p = partition(a,b,low,high);
            quickSort(a,b,low,p-1);
            quickSort(a,b,p+1,high);
        }
    }
    public static int partition(int a[],int b[], int low, int high)
    {
        // your code here
        int j=low,pivot=b[high];
        for(int i=low;i<=high;i++){
            if(b[i]<=pivot){
                int temp=b[j];
                b[j]=b[i];
                b[i]=temp;
                temp = a[j];
                a[j] = a[i];
                a[i] = temp;
                j++;
            }
        }
        return j-1;
    }
    
    static int maxCoins(int[] a, int[] b, int t, int n) {
        // code here
        quickSort(a,b,0,n-1);
        int value = 0;
        for(int i=n-1;i>=0 && t>0;i--){
            value += Math.min(a[i],t) * b[i];
            t -= a[i];
        }
        return value;
    }
}
