package array;

public class GreaterOnRightSide {
	 static void nextGreatest(int arr[], int n) {
        // code here
        int greatest = arr[n-1];
        arr[n-1]=-1;
        for(int i=n-2;i>=0;i--){
            int temp=greatest;
            greatest = Math.max(greatest,arr[i]);
            arr[i]=temp;
        }
    }
}
