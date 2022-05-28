package misc;
// Given two jugs with capacity m and n and an infinite supply of water
// Our task is to find the minimum numbers of steps to fill a jug with d amount of water
// If it isn't possible to fill the jug with d water then return -1
public class TwoWaterJugProblem {
	static int gcd(int a,int b){
        if(b == 0) return a;
        return gcd(b,a%b);
    }
    static int pour(int m,int n,int d){
        int steps=0;
        int x=0,y=0;
        while(x != d && y != d){
            if(x == 0){
                x=m;
                steps++;
                System.out.print("(" + x + "," + y + ")" + " ");
            }
            int temp=Math.min(n-y,x);
            x-=temp;
            y+=temp;
            steps++;
            System.out.print("(" + x + "," + y + ")" + " ");
            if(x==d||y==d) break;
            if(y==n){
                y=0;
                steps++;
                System.out.print("(" + x + "," + y + ")" + " ");
            }
        }
        return steps;
    }
    public static int minSteps(int m, int n, int d)
    {
        // code here
        if(d%gcd(m,n)!=0 || d>m+n) return -1;
        if(d == m || d == n) return 1;
        if(d==m+n || d==n-m) return 2;
        return Math.min(pour(m,n,d),pour(n,m,d));
    }
    public static void main(String[] args) {
		minSteps(20,27,19);
	}
}
