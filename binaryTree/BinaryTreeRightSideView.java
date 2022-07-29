package binaryTree;
// leetcode # 199
import java.util.*;
public class BinaryTreeRightSideView {
	public static List<Integer> rightSideView(BinTree root) {
        Queue<BinTree> q = new LinkedList<>();
        List<Integer> rightView = new ArrayList<>();
        if(root == null) return rightView;
        int n=1;
        q.add(root);
        while(!q.isEmpty()){
            int m=0;
            rightView.add(q.peek().val);
            while(n>0){
                BinTree temp = q.poll();
                if(temp.right != null){
                    q.add(temp.right);
                    m++;
                }
                if(temp.left != null){
                    q.add(temp.left);
                    m++;
                }
                n--;
            }
            n = m;
        }
        return rightView;
    }
}
