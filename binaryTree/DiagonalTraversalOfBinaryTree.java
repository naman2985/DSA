package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DiagonalTraversalOfBinaryTree {
	public static ArrayList<Integer> diagonal(Node root)
    {
         //add your code here
         ArrayList<Integer> curr = new ArrayList<>();
         Queue<Node> q = new LinkedList<>();
         q.add(root);
         while(!q.isEmpty()){
             Node ptr = q.poll();
             while(ptr != null){
                 if(ptr.left != null) q.add(ptr.left);
                 curr.add(ptr.data);
                 ptr = ptr.right;
             }
         }
         return curr;
    }
}
