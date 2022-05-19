package binaryTree;

import java.util.ArrayList;
/*
 * Given a binary tree of N nodes, where every node value is a number. 
 * Find the sum of all the numbers which are formed from root to leaf paths.
 *         6                               
         /   \                          
        3     5                      
      /   \     \
     2    5      4             
        /  \                        
       7    4  
       
       Output: 13997

Explanation :
There are 4 leaves, hence 4 root to leaf paths:
Path                      Number
6->3->2                   632
6->3->5->7                6357
6->3->5->4                6354
6->5>4                    654   
Answer = 632 + 6357 + 6354 + 654 = 13997 
 */
public class SumOfAllNumbersFormedFromRootToLeafPaths {
	static long sum;
    static ArrayList<Integer> arr;
    static long arrayToNum(ArrayList<Integer> arr){
        long num = 0;
        int n=arr.size();
        for(int i=0;i<n;i++){
            num = num *10 + arr.get(i);
        }
        return num;
    }
    
    public static void pathSum(BinTree root,ArrayList<Integer> arr){
        if(root == null) return;
        arr.add(root.val);
        if(root.left == null && root.right == null){
            sum += arrayToNum(arr);
        }
        pathSum(root.left,arr);
        pathSum(root.right,arr);
        arr.remove(arr.size()-1);
    }
    
	public static long treePathsSum(BinTree root)
    {
        sum = 0;
        arr = new ArrayList<>();
        pathSum(root,arr);
        return sum;
	}
}
