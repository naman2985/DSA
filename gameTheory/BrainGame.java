package gameTheory;

/* 
 * two players A and B take turns to play a game in which n numbers are written on a paper, in one turn a player must reduce one of the numbers to 
 * one of its factors (except itself and 1). if one of the players is unable to take his turn he loses. if A starts the game, determine if A wins
 * the game or not.
 */

public class BrainGame {
	static int timesReduced(int n){
        if(n==1) return 0;
        int count=0;
        for(int i=2;i<=n;i++){
            while(n%i == 0){
                count++;
                n/=i;
            }
        }
        return count-1;
    }
    public static boolean brainGame(int[] nums)
    {
        // Code here
        int sum=0;
        for(int i:nums){
            int temp=timesReduced(i);
            sum^=temp;
        }
        return (sum!=0);
    }
}
