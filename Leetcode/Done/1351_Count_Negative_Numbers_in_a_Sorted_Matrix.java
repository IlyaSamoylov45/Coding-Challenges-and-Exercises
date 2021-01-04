// Given a m * n matrix grid which is sorted in non-increasing order both row-wise and column-wise.
//
// Return the number of negative numbers in grid.
//
//
//
// Example 1:
//
// Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
// Output: 8
// Explanation: There are 8 negatives number in the matrix.
// Example 2:
//
// Input: grid = [[3,2],[1,0]]
// Output: 0
// Example 3:
//
// Input: grid = [[1,-1],[-1,-1]]
// Output: 3
// Example 4:
//
// Input: grid = [[-1]]
// Output: 1
//
//
// Constraints:
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 100
// -100 <= grid[i][j] <= 100




class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for(int[] row : grid){
            count += binaryCount(row);
        }
        return count;
    }

    private int binaryCount(int[] row){

        int left = 0;
        int right = row.length - 1;
        if(row[right] >= 0){
            return 0;
        }
        while(left <= right){
            int mid = (right - left)/2 + left;
            if(row[mid] < 0){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return row.length - left;
    }
}
// Time : O(Log(N))
// Space : O(1)
