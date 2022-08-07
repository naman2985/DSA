package searchAndSort;
/* 
 * Given an array, an element x and a number k,
 * find the k closest elements to x in the array the array,
 * - x should be excluded
 * - in case of equal closeness, for two elements, first preference is given to the greater element
 */ 
public class KClosestElements {
	static int[] printKClosest(int[] arr, int n, int k, int x) {
        // code here
        int closest[] = new int[k];
        int i = 0;
        int beg = 0, end = n - 1, mid = (beg + end)/2;
        while(beg < end){
            if(arr[mid] == x || (end - beg <= 2 && arr[beg] < x && arr[end] > x))
                break;
            else if(arr[mid] < x)
                beg = mid + 1;
            else end = mid - 1;
            mid = (beg + end) / 2;
        }
        beg = arr[mid] < x?mid:mid-1;
        end = arr[mid] > x?mid:mid+1;
        while(i < k){
            if(end == n || beg >= 0 && x - arr[beg] < arr[end] - x)
                closest[i++] = arr[beg--];
            else
                closest[i++] = arr[end++];
        }
        return closest;
    }
}
