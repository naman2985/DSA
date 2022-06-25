package binarySearchTree;

import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

public class MergeTwoBST {
	static void fill(Node root,List<Integer> list){
        if(root!=null){
            fill(root.left,list);
            list.add(root.data);
            fill(root.right,list);
        }
    }
    static List<Integer> mergeList(List<Integer> l1,List<Integer> l2){
        List<Integer> merged=new ArrayList<>();
        int n1=l1.size(),n2=l2.size(),i=0,j=0;
        while(i<n1 && j<n2){
            if(l1.get(i)<l2.get(j)){
                merged.add(l1.get(i++));
            }
            else merged.add(l2.get(j++));
        }
        while(i<n1) merged.add(l1.get(i++));
        while(j<n2) merged.add(l2.get(j++));
        return merged;
    }
    public List<Integer> merge(Node root1,Node root2)
    {
        // Write your code here
        List<Integer> l1=new ArrayList<>();
        List<Integer> l2=new ArrayList<>();
        fill(root1,l1);
        fill(root2,l2);
        return mergeList(l1,l2);
    }
}
