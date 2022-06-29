package array;

public class MaximumPointsYouCanObtainFromCards {
	static int maxScore(int[] cardPoints, int k) {
        int sum=0,n=cardPoints.length,start=0,last=0,currSum=0,midSum=0;
        for(int i=0;i<n;i++) sum+=cardPoints[i];
        if(k == n) return sum;
        while(last<n-k){
            currSum += cardPoints[last];
            last++;
        }
        midSum=currSum;
        while(last<n){
            currSum += cardPoints[last] - cardPoints[start];
            last++;
            start++;
            midSum=Math.min(midSum,currSum);
        }
        return sum-midSum;
    }
}
