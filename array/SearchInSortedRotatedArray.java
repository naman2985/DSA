package array;

public class SearchInSortedRotatedArray {
	int search(int A[], int l, int h, int key)
    {
        while(l < h){
            int mid = (l+h)/2;
            if(A[mid] == key) return mid;
            if(A[l] < A[mid]){
                if(key <= A[mid] && key >= A[l]) h = mid - 1;
                else l = mid +1;
            }
            else{
                if(key <= A[h] && key >= A[mid]) l = mid +1 ;
                else h = mid - 1;
            }
        }
        if(A[l] == key) return l;
        return -1;
    }
}
