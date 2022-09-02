package array;

public class MinimumElementInASortedAndRotatedArray {
	static int findMin(int arr[], int n)
    {
        //complete the function here
        int b=0,e=n-1,m=0;
        while(b<=e){
            m = (b + e)/2;
            if(m > 0 && arr[m-1] > arr[m])
                return arr[m];
            else if(arr[m] < arr[n-1])
                e = m - 1;
            else b = m + 1;
        }
        return arr[m];
    }
}
