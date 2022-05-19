package binaryTree;

import java.util.HashMap;

/*
 * Given a binary tree with a value associated with each node,
 * we need to choose a subset of these nodes such that sum of 
 * chosen nodes is maximum under a constraint that no two chosen 
 * node in subset should be directly connected that is, if we have 
 * taken a node in our sum then we can’t take its any children or 
 * parents in consideration and vice versa.
 * 
 */
public class MaximumSumOfNonAdjacentNodes {
	static int max(int a,int b){
        return a>=b?a:b;
    }
    
    static int maxUtil(BinTree root,HashMap<BinTree,Integer> map){
        if(root == null) return 0;
        if(map.containsKey(root)) return map.get(root);
        int child = maxUtil(root.left,map) + maxUtil(root.right,map);
        int here = root.val;
        if(root.left != null){here += maxUtil(root.left.left,map) + maxUtil(root.left.right,map);}
        if(root.right != null){here += maxUtil(root.right.left,map) + maxUtil(root.right.right,map);}
        map.put(root,max(child,here));
        return map.get(root);
    }
    
    static int getMaxSum(BinTree root)
    {
        if(root == null) return 0;
        HashMap<BinTree,Integer> map = new HashMap<>();
        return maxUtil(root,map);
    }
}
