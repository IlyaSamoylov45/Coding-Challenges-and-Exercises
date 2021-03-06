// Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
//
//
//
// Example 1:
//
// Input: matrix =
// [
//   [0,1,1,1],
//   [1,1,1,1],
//   [0,1,1,1]
// ]
// Output: 15
// Explanation:
// There are 10 squares of side 1.
// There are 4 squares of side 2.
// There is  1 square of side 3.
// Total number of squares = 10 + 4 + 1 = 15.
// Example 2:
//
// Input: matrix =
// [
//   [1,0,1],
//   [1,1,0],
//   [1,1,0]
// ]
// Output: 7
// Explanation:
// There are 6 squares of side 1.
// There is 1 square of side 2.
// Total number of squares = 6 + 1 = 7.
//
//
// Constraints:
//
// 1 <= arr.length <= 300
// 1 <= arr[0].length <= 300
// 0 <= arr[i][j] <= 1






class Solution {
    public int countSquares(int[][] matrix) {
        int sum = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(i == 0 || j == 0){
                    sum += matrix[i][j];
                }else if(matrix[i][j] == 1){
                    matrix[i][j] += Math.min(Math.min(matrix[i - 1][j], matrix[i][j - 1]), matrix[i - 1][j - 1]);
                    sum += matrix[i][j];
                }
            }
        }
        return sum;
    }
}
// Time : O(N * M)
// Space : O(1)







class Solution {
    public int countSquares(int[][] matrix) {
        int sum = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 1 && i > 0 && j > 0){
                    matrix[i][j] += Math.min(Math.min(matrix[i - 1][j], matrix[i][j - 1]), matrix[i - 1][j - 1]);
                }
                sum += matrix[i][j];
            }
        }
        return sum;
    }
}
// Time : O(N * M)
// Space : O(1)
