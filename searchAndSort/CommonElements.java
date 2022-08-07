package searchAndSort;

import java.util.ArrayList;

public class CommonElements {
	static ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) 
    {
        // code here
        ArrayList<Integer> common = new ArrayList<>();
        for(int i1=0,i2=0,i3=0;i1<n1 && i2<n2 && i3<n3;){
            if(A[i1] < B[i2] || A[i1] < C[i3])
                i1++;
            else if(B[i2] < A[i1] || B[i2] < C[i3])
                i2++;
            else if(C[i3] < A[i1] || C[i3] < B[i2])
                i3++;
            else{
                if(common.size() == 0 || common.get(common.size()-1) != A[i1])
                    common.add(A[i1]);
                i1++;i2++;i3++;
            }
        }
        return common;
    }
}
