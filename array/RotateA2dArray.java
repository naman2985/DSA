package array;
// given an n*n array rotate it anti-clockwise by 90 degrees
public class RotateA2dArray {
	static void rotateMatrix(int arr[][], int n) {
        // code here
        for(int j=0;j<n/2;j++){
            for(int i=0;i<n;i++){
                int temp = arr[i][j];
                arr[i][j] = arr[i][n-j-1];
                arr[i][n-j-1] = temp;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }
}
