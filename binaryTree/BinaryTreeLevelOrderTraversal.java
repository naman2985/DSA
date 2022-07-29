package binaryTree;

import java.util.*;

// leetcode # 102
public class BinaryTreeLevelOrderTraversal {
	public static List<List<Integer>> levelOrder(BinTree root) {
        List<List<Integer>> traversal = new ArrayList<>();
        if(root == null) return traversal;
        Queue<BinTree> q = new LinkedList<>();
        traversal.add(new ArrayList<>());
        traversal.get(0).add(root.val);
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> level = new ArrayList<>();
            while(n-- > 0){
                BinTree temp = q.poll();
                if(temp.left != null){
                    q.add(temp.left);
                    level.add(temp.left.val);
                }
                if(temp.right != null){
                    q.add(temp.right);
                    level.add(temp.right.val);
                }
            }
            if(level.size() > 0) traversal.add(level);
        }
        return traversal;
    }
}
