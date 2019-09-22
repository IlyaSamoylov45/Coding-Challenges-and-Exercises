/*
You are given a square 2D image matrix where each integer represents a pixel. Write a method transposeMatrix to transform the matrix into its Transpose - in-place.

Example:Input image :
1 0
1 0
Modified to :
1 1
0 0
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static void transposeMatrix(int[][] matrix) {
    int row = matrix.length;
    int col = matrix[0].length;
    for(int i = 0; i < row; i++){
        for(int j = i; j < col; j++){
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }
}
