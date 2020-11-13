// Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
//
// Example 1:
//
// Input:
// [
//  [ 1, 2, 3 ],
//  [ 4, 5, 6 ],
//  [ 7, 8, 9 ]
// ]
// Output: [1,2,3,6,9,8,7,4,5]
// Example 2:
//
// Input:
// [
//   [1, 2, 3, 4],
//   [5, 6, 7, 8],
//   [9,10,11,12]
// ]
// Output: [1,2,3,4,8,12,11,10,9,5,6,7]



class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();
        if (matrix.length == 0){
            return spiral;
        }
        int left = 0;
        int top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        while(left<=right && top<=bottom){
            for(int i = left; i <= right; i++){
                spiral.add(matrix[top][i]);
            }
            top++;
            for(int i = top; i <= bottom; i++){
                spiral.add(matrix[i][right]);
            }
            right--;
            if(left <= right && top <= bottom){
                for(int i = right; i >= left; i--){
                    spiral.add(matrix[bottom][i]);
                }
                bottom--;
                for(int i = bottom; i >= top; i--){
                    spiral.add(matrix[i][left]);
                }
                left++;
            }
        }
        return spiral;
    }
}
// Time : O(N)
// Space : O(N)
