package searchAndSort;

public class PunishStudents {
	public static int shouldPunish (int roll[], int marks[], int n, double avg)
    {
        // your code here
        int swaps=0,sum=0;
        for(int i=n-1;i>=0;i--){
            sum+=marks[i];
            for(int j=0;j<i;j++){
                if(roll[j]>roll[j+1]){
                    int temp=roll[j];
                    roll[j]=roll[j+1];
                    roll[j+1]=temp;
                    swaps++;
                }
            }
        }
        double newAvg=((sum-2*swaps)*1.0)/n;
        return newAvg>avg?1:0;
    }
}
