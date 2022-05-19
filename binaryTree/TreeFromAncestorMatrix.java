/*
 * Given a matrix containing only zero and ones. Create a binary tree from the matrix.
 * In the given matrix if mat[i][j] = 1 then i is an ancestor of j, 0 otherwise
 * 
 */


package binaryTree;

import java.util.*;
import java.util.stream.Collectors;

public class TreeFromAncestorMatrix {
	static BinTree ancestorTree(int[][] anc) {
		int n = anc.length;
        int[] parent = new int[n];
        BinTree root = null;
        Map<Integer, Integer> map = new HashMap<>();
 
        for (int i = 0; i < n; i++) {
            int sum = 0;
 
            for (int j = 0; j < n; j++)
                sum += anc[i][j];
 
            map.put(i, sum);
        }
        BinTree node[] = new BinTree[n];
        Map<Integer, Integer> sorted
            = map.entrySet()
              .stream()
              .sorted(Map.Entry.comparingByValue())
              .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(),
                  (e1, e2) -> e2, LinkedHashMap::new));
        for (Map.Entry<Integer, Integer> entry :sorted.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            node[key] = new BinTree(key);
            if (value != 0) {
                for (int i = 0; i < n; i++)
                {
                    if (parent[i] == 0 && anc[key][i] == 1)
                    {
                        if (node[key].left == null) node[key].left = node[i];
                        else node[key].right = node[i];
                        parent[i] = 1;
                    }
                    root = node[key];
                }
            }
        }
 
        return root;
	}
	public static void main(String[] args) {
		int mat[][] = {
            { 0, 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 1, 0 },
            { 0, 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1, 0 }
	    };
        BinTree root = ancestorTree(mat);
        root.inorder();
	}
}
