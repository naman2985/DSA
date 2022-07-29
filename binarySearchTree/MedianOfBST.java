package binarySearchTree;

public class MedianOfBST {
	static int count;
    static float median;
    static int getTreeSize(Node root){
        if(root == null) return 0;
        return getTreeSize(root.left) + getTreeSize(root.right) + 1;
    }
    static void getMedian(Node root,int n){
        if(root != null){
            getMedian(root.left,n);
            if(count == (n-1)/2){
                median += root.data;
                if(n%2 == 1){
                    median += root.data;
                }
            }
            if(n%2 == 0 && count == n/2){
                median += root.data;
            }
            count++;
            getMedian(root.right,n);
        }
    }
    public static float findMedian(Node root)
    {
        // code here.
        int n = getTreeSize(root);
        count = 0;
        median = 0;
        getMedian(root,n);
        return median/2;
    }
}
