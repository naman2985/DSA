package searchAndSort;

/*
 * Given a list of non negative integers, arrange them in such a manner 
 * that they form the largest number possible. 
 * The result is going to be very large, hence return the result in the form of a string.
 */

public class LargestNumberFormedFromAnArray {
	private static boolean isBigger(String x,String y){
        String xy = x + y;
        String yx = y + x;
        int l = Math.min(Math.min(xy.length(),yx.length()), 18);
        if(Long.parseLong(xy.substring(0,l)) >= Long.parseLong(yx.substring(0,l)))
            return true;
        else return false;
    }
    
    static int partition(String arr[],int l,int h){
        int j=l;
        for(int i=l;i<h;i++){
            if(isBigger(arr[i], arr[h])){
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        String temp = arr[j];
        arr[j] = arr[h];
        arr[h] = temp;
        return j;
    }
    
    static void sort(String arr[],int l,int h){
        if(l < h){
            int p = partition(arr,l,h);
            sort(arr,l,p-1);
            sort(arr,p+1,h);
        }
    }
    
    static String printLargest(String[] arr) {
        // code here
        StringBuilder sb = new StringBuilder();
        sort(arr,0,arr.length-1);
        for(String i:arr) sb.append(i);
        return sb.toString();
    }
}
