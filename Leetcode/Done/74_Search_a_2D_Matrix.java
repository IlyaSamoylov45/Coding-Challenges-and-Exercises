// Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
//
// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previous row.
//
//
// Example 1:
//
//
// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
// Output: true
// Example 2:
//
//
// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
// Output: false
// Example 3:
//
// Input: matrix = [], target = 0
// Output: false
//
//
// Constraints:
//
// m == matrix.length
// n == matrix[i].length
// 0 <= m, n <= 100
// -1^04 <= matrix[i][j], target <= 10^4




class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int n = matrix.length;
	      int m = matrix[0].length;
        int left = 0;
        int right = n * m - 1;
        while(left <= right){
            int mid = (right - left)/2 + left;
            int mid_value = matrix[mid/m][mid%m];
            if(mid_value == target){
                return true;
            }else if(mid_value < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }
}
// Time : O(LOG(N) + LOG(M))
// Space : O(1)
