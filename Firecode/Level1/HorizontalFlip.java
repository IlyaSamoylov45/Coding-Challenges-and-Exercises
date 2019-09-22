 /*
You are given an m x n 2D image matrix where each integer represents a pixel.
Flip it in-place along its horizontal axis.

Example:

Input image :
              1 1
              0 0
Modified to :
              0 0
              1 1
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static void flipHorizontalAxis(int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;
    for(int i = 0; i < n/2; i++){
        for(int j = 0; j < m; j++){
            int temp = matrix[i][j];
            matrix[i][j] = matrix[n-i-1][j];
            matrix[n-i-1][j] = temp;
        }
    }
}
