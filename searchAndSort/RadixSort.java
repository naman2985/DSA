package searchAndSort;

public class RadixSort {
	static void countSort(int arr[], int size, int div,int mod) {
        int count[] = new int[11];
        int temp[] = new int[size];
        for(int i=0;i<size;i++){
            count[(arr[i]%mod)/div + 1] += 1;
        }
        for(int i=2;i<=10;i++){
            count[i] += count[i-1];
        }
        for(int i=0;i<size;i++){
            temp[count[(arr[i]%mod)/div]] = arr[i];
            count[(arr[i]%mod)/div] += 1;
        }
        for(int i=0;i<size;i++){
            arr[i] = temp[i];
        }
    }
    
    public static void sort(int arr[], int n)
    {
        // your code here
        int div = 1, mod = 10;
        int max = 0;
        for(int i:arr) max = Math.max(max,i);
        while(max / div > 0){
            countSort(arr,n,div,mod);
            div = mod;
            mod *= 10;
        }
    }
}
