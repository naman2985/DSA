package graph;
// Given a parent array (an array which contains the index of parent of the current node) find the height of the n-ary tree
public class HeightOfGenericTreeFromParentArray {
	static int heightOfTree(int parent[]) {
		int n=parent.length, depth[] = new int[n];
		depth[0] = 0;
		for(int i=1;i<n;i++) {
			depth[i] = depth[parent[i]] + 1;
		}
		return depth[n-1];
	}
	public static void main(String[] args) {
		int parent1[] = {-1, 0, 0, 0, 3, 1, 1, 2};
		System.out.println(heightOfTree(parent1));
		int parent2[] = {-1, 0, 1, 2, 3};
		System.out.println(heightOfTree(parent2));
	}
}
