package array;

import java.util.ArrayList;
import java.util.Arrays;

public class RearrangeArraySuchThatEvenPositionedAreGreaterThanOdd {
	static ArrayList<Integer> assign(int a[], int n)
    {
        // Complete the function
        ArrayList<Integer> arr = new ArrayList<>();
        Arrays.sort(a);
        for(int i=1;i<n;i++){
            if(i % 2 == 0){
                if(a[i] > a[i-1]){
                    int temp = a[i];
                    a[i] = a[i-1];
                    a[i-1] = temp;
                }
            }
            else{
                if(a[i] < a[i-1]){
                    int temp = a[i];
                    a[i] = a[i-1];
                    a[i-1] = temp;
                }
            }
        }
        for(int i:a)
            arr.add(i);
        return arr;
    }
}
