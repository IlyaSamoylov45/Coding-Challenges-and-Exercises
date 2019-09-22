/*
You are given an m x n 2D image matrix where each integer represents a pixel.
Flip it in-place along its vertical axis.

Example:
Input image :
              1 0
              1 0

Modified to :
              0 1
              0 1
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static void flipItVerticalAxis(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n/2; j++){
            int temp = matrix[i][j];
            matrix[i][j] = matrix[i][n-j-1];
            matrix[i][n-j-1] = temp;
        }
    }
}
