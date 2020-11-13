// Given an m x n matrix filled with non-negative integers, use dynamic programming techniques to find the maximum sum along a path from the top-left of the grid to the bottom-right. Return this maximum sum. The direction of movement is limited to right and down.
//
// Example:
// Input Matrix :
//
//     1 2 3
//     4 5 6
//     7 8 9
//
// Output  : 1 + 4 + 7 + 8 + 9 = 29
//
//
// Note:
// You may have previously solved the DFS variant of this problem. That won't work for large sized matrices - just consider the size of the recursion tree for a 100x100 matrix! Dynamic Programming should afford a better solution.



// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static int matrixMaxSumDP(int[][] grid) {
    for(int i = grid.length - 1; i >= 0; i--){
        for(int j = grid[i].length - 1; j >= 0; j--){
            if( i == grid.length - 1 && j == grid[i].length - 1){
                continue;
            }
            if(i == grid.length - 1){
                grid[i][j] += grid[i][j+1];
            }
            else if(j == grid[i].length - 1){
                grid[i][j] += grid[i+1][j];
            }else{
                grid[i][j] += Math.max(grid[i+1][j], grid[i][j+1]);
            }
        }
    }
    return grid[0][0];
}
// Time : O(N*M)
// Space : O(1)
