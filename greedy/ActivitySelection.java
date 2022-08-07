package greedy;
/* Given two arrays start and end containing start and end times of n jobs,
 * return the maximum number of jobs that can be completed such that no two
 * jobs' schedule overlap
 */
public class ActivitySelection {
	private static int partition(int start[], int end[],int m,int n){
        int j=m;
        for(int i=m;i<n;i++){
            if(end[i] <= end[n]){
                int temp = end[i];
                end[i] = end[j];
                end[j] = temp;
                
                temp = start[i];
                start[i] = start[j];
                start[j] = temp;
                j++;
            }
        }
        int temp = end[n];
        end[n] = end[j];
        end[j] = temp;
        
        temp = start[n];
        start[n] = start[j];
        start[j] = temp;
        return j;
    }
    
    private static void quickSort(int start[],int end[],int m, int n){
        if(m < n){
            int p = partition(start,end,m,n);
            quickSort(start,end,m,p-1);
            quickSort(start,end,p+1,n);
        }
    }
    public static int activitySelection(int start[], int end[], int n)
    {
        // add your code here
        int endTime = -1, jobs=0;
        quickSort(start,end,0,n-1);
        for(int i=0;i<n;i++){
            if(start[i] > endTime){
                endTime = end[i];
                jobs++;
            }
        }
        return jobs;
    }
}
