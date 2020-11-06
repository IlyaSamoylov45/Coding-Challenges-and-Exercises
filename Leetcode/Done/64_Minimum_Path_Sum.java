// Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
//
// Note: You can only move either down or right at any point in time.
//
// Example:
//
// Input:
// [
//   [1,3,1],
//   [1,5,1],
//   [4,2,1]
// ]
// Output: 7
// Explanation: Because the path 1→3→1→1→1 minimizes the sum.




class Solution {
    public int minPathSum(int[][] grid) {
        int[] dp = new int[grid[0].length];
        dp[0] = grid[0][0];
        for(int j = 1; j < grid[0].length; j++){
            dp[j] += grid[0][j] +  dp[j-1];
        }
        for(int i = 1; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(j == 0){
                    dp[j] += grid[i][0];
                    continue;
                }

                dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1] );
            }
        }
        return dp[dp.length - 1];
    }
}
// Time : O(M*N)
// Space : O(N)




class Solution {
    public int minPathSum(int[][] grid) {
        for(int i = 1; i < grid.length; i++){
            grid[i][0] += grid[i-1][0];
        }
        for(int j = 1; j < grid[0].length; j++){
            grid[0][j] += grid[0][j - 1];
        }
        for(int i = 1; i < grid.length; i++){
            for(int j = 1; j < grid[i].length; j++){
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}
// Time : O(NM)
// Space : O(1)
