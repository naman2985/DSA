package array;
// given a sorted array rotated to the right k times, find the value of k
public class NumberOfRotations {
	static int findKRotation(int arr[], int n) {
        // code here
        int b = 0,e = n-1, m = 0;
        while(b <= e){
            m = (b+e)/2;
            if(m > 0 && arr[m] < arr[m-1])
                return m;
            else if(arr[m] < arr[n-1])
                e = m - 1;
            else b = m + 1;
        }
        return m;
    }
}
