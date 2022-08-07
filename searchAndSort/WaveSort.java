package searchAndSort;

public class WaveSort {
	public static void convertToWave(int n, int[] a) {
        // code here
        for(int i=1;i<n;i+=2){
            int temp = a[i];
            a[i] = a[i-1];
            a[i-1] = temp;
        }
    }
}
