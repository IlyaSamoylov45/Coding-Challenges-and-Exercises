// Given a two dimensional matrix made up of 0's and 1's, find the largest square containing all 1's and return its 'area'. The 'area' is simply the sum of all integers enclosed in the square.
// Example:
//
// Input Matrix :
//
//   1101
//   1101
//   1111
//
// Output  : 4





// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static int largestSquare(char[][] matrix) {
    if(matrix.length == 0){
        return 0;
    }
    int n = matrix.length;
    int m = matrix[0].length;
    int max = 0;
    int[][] squares = new int[n][m];
    for(int i = 0; i < n; i++){
        squares[i][0] = matrix[i][0] == '0' ? 0 : 1;
        max = Math.max(squares[i][0], max);
    }
    for(int j = 0; j < m; j++){
        squares[0][j] = matrix[0][j] == '0' ? 0 : 1;
        max = Math.max(squares[0][j], max);
    }

    for(int i = 1; i < n; i++){
        for(int j = 1; j < m; j++){
            if(matrix[i][j] == '1'){
                squares[i][j] = Math.min(Math.min(squares[i - 1][j], squares[i][j - 1]), squares[i - 1][j - 1]) + 1;
                max = Math.max(squares[i][j], max);
            }
        }
    }
    return max * max;
}
// Time : O(N * M)
// Space : O(N * M)
