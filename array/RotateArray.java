package array;

public class RotateArray {
	static int gcd(int a,int b){
        if(b==0) return a;
        else return gcd(b,a%b);
    }
    static void rotateArr(int arr[], int d, int n)
    {
        // add your code here
        int g=gcd(n,d);
        d=d%n;
        for(int i=0;i<g;i++){
            int temp=arr[i];
            int k=i;
            for(int j=i+d;;j+=d){
                j=j%n;
                if(j==i){
                    arr[k]=temp;
                    break;
                }
                arr[k]=arr[j];
                k=j;
            }
        }
    }
}
