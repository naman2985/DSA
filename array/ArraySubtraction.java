package ArraysProblems;

public class ArraySubtraction {
    static void subtractArrayUtil(int first[],int second[]){
    	int n1 = first.length;
        int n2 = second.length;
        int n3 = n1 > n2 ? n1 : n2;
        int third[] = new int[n3];
        int i = n1 - 1;
        int j = n2 - 1;
        int k = n3 - 1;
        int carry = 0;
        int diff = 0;
        while(k >= 0) {
        	if(j>=0 && first[i]<second[j]){
        		int temp=i-1;
        		while(first[temp]==0) temp--;
        		while(temp<i){
        			first[temp+1]+=10;
        			first[temp]-=1;
        			temp++;
        		}
        	}
        	if(j>=0) 
        		third[k] =first[i]-second[j];
            else third[k]=first[i];
            i--;
            j--;
            k--;
        }
        for(int t:third)
        	System.out.print(t + " ");
    }
    static void subtractArray(int a[],int b[]){
    	int m=a.length,n=b.length;
    	if(m > n){
    		subtractArrayUtil(a,b);
    	}
    	else if(n>m){
    		subtractArrayUtil(b,a);
    	}
    	else{
    		for(int i=0;i<m;i++){
    			if(a[i]>b[i]){
    				subtractArrayUtil(a,b);
    				return;
    			}
    			else if(b[i]>a[i]){
    				subtractArrayUtil(a,b);
    				return;
    			}
    		}
    		subtractArrayUtil(a,b);
    	}
    }
    public static void main(String[] args) {
        int first[] = {9,1,8,9,2};
        int second[] =  {9,1,2,7};
        subtractArray(first,second);
    }
}
