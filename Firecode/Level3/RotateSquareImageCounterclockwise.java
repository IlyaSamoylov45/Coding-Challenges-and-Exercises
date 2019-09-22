/*
You are given a square 2D image matrix where each integer represents a pixel. Write a method rotateSquareImageCCW to rotate the image counterclockwise - in-place. This problem can be broken down into simpler sub-problems you've already solved earlier! Rotating an image counterclockwise can be achieved by taking the transpose of the image matrix and then flipping it on its horizontal axis. Source: en.wikipedia.org/wiki/Transpose
Example:
Input image :
1 0
1 0
Modified to :
0 0
1 1
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static void rotateSquareImageCCW(int[][] matrix) {
    int N = matrix.length;
    int M = matrix[0].length;
    for(int x = 0; x < N/2; x++){
        for(int y = x; y < M - x - 1; y++){
            int temp = matrix[x][y];

            matrix[x][y] = matrix[y][N-1-x];

            matrix[y][N-1-x] = matrix[N-1-x][N-1-y];

            matrix[N-1-x][N-1-y] = matrix[N-1-y][x];

            matrix[N-1-y][x] = temp;
        }
    }
}
