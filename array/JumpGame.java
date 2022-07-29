package array;

public class JumpGame {
	static int canReach(int[] arr, int n) {
        // code here
        int maxJump = 0;
        for(int i=n-2;i>=0;i--){
            maxJump++;
            if(arr[i] >= maxJump) maxJump=0;
        }
        return (maxJump == 0)?1:0;
    }
}
