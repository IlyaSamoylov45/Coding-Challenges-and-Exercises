/*
You are given a square 2D image matrix where each integer represents a pixel. Write a method rotateSquareImageCW to rotate the image clockwise - in-place. This problem can be broken down into simpler sub-problems you've already solved earlier! Rotating an image clockwise can be achieved by taking the transpose of the image matrix and then flipping it on its vertical axis.

Example:Input image :
1 0
1 0
Modified to :
1 1
0 0
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static void rotateSquareImageCW(int[][] matrix) {
    int n = matrix.length;
    for(int i = 0; i < n/2; i++){
        for(int j = i; j < n - i - 1; j++){
            int temp = matrix[i][j];
            matrix[i][j] = matrix[n - 1 - j][i];
            matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
            matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
            matrix[j][n - 1 - i] = temp;
        }
    }

}
