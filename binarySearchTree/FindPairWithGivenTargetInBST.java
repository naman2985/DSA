package binarySearchTree;

import java.util.Stack;

public class FindPairWithGivenTargetInBST {
	public int isPairPresent(BST root, int target)
    {
        BST curr1 = root,curr2 = root;
        int val1=0,val2=0;
        Stack<BST> s1 = new Stack<>();
        Stack<BST> s2 = new Stack<>();
        boolean done1=false,done2=false;
        while(true){
            while(!done1){
                if(curr1 != null){
                    s1.push(curr1);
                    curr1 = curr1.left;
                }
                else{
                    if(s1.isEmpty()){
                        done1 = true;
                    }
                    else{
                        curr1 = s1.pop();
                        val1 = curr1.val;
                        curr1 = curr1.right;
                        done1 = true;
                    }
                }
            }
            while(!done2){
                if(curr2 != null){
                    s2.push(curr2);
                    curr2 = curr2.right;
                }
                else{
                    if(s2.isEmpty()){
                        done2 = true;
                    }
                    else{
                        curr2 = s2.pop();
                        val2 = curr2.val;
                        curr2 = curr2.left;
                        done2 = true;
                    }
                }
            }
            if(val1 + val2 == target && val1 != val2) return 1;
            else if(val1 + val2 > target) done2 = false;
            else if(val1 + val2 < target) done1 = false;
            if(val1 >= val2) break;
        }
        return 0;
    }
}
