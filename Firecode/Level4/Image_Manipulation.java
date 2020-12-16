// You are given an n x n square 2D matrix that represents the pixels of an image.
// Rotate it by 90 degrees in the clockwise direction.
//
// Example:
//
// Input Matrix :
//
//               1 0
//               0 1
//
// Output       :
//
//               0 1
//               1 0




// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static int[][] rotate(int[][] matrix) {
    for(int i = 0; i < matrix.length; i++){
        for(int j = i + 1; j < matrix[i].length; j++){
            int temp=matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }

    for(int i = 0; i < matrix.length; i++){
        for(int j = 0; j < matrix[i].length/2; j++){
            int temp = matrix[i][j];
            matrix[i][j] = matrix[i][matrix[i].length - j - 1];
            matrix[i][matrix[i].length - j - 1] = temp;
        }
    }

    return matrix;


}
