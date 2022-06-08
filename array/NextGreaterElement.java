import java.util.Stack;
public class NextGreaterElement {
	static int[] findNext(int[] arr){
		Stack<Integer> s=new Stack<>();
		int n=arr.length;
		int[] res=new int[n];
		for(int i=2*n-1;i>=0;i--){
			
			while(!s.isEmpty()&&s.peek()<=arr[i%n]) s.pop();
			if(s.isEmpty()) res[i%n]=-1;
			else res[i%n]=s.peek();
			s.push(arr[i%n]);
		}
		for(int i:res) System.out.print(i+" ");
		return res;
	}
	public static void main(String[] args) {
		int[] arr={1,2,3,4,3};
		findNext(arr);
	}
}