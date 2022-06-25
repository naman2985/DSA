package graph;

public class FloydWarshall {
	public static void shortest_distance(int[][] matrix)// -1 value for two unconnected nodes
    {
        // Code here 
        int V=matrix.length;
        for(int k=0;k<V;k++){
            for(int i=0;i<V;i++){
                for(int j=0;j<V;j++){
                    if(i==j || matrix[i][k]==-1 || matrix[k][j]==-1) continue;
                    if(matrix[i][j]==-1)
                        matrix[i][j]=matrix[i][k]+matrix[k][j];
                    else matrix[i][j]=Math.min(matrix[i][j],matrix[i][k]+matrix[k][j]);
                }
            }
        }
    }
}
