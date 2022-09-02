package array;

public class EaseTheArray {
	static void modifyAndRearrangeArr (int arr[], int n) {
        // Complete the function
        for(int i=0;i<n-1;i++){
            if(arr[i] != 0 && arr[i+1] == arr[i]){
                arr[i] *= 2;
                arr[i+1] = 0;
            }
        }
        int j = 0;
        for(int i=0;i<n;i++){
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        while(j < n) arr[j++] = 0;
    }
}
