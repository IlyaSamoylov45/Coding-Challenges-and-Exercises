// Given an m x n matrix filled with non-negative integers, find the minimum sum along a path from the top-left of the grid to the bottom-right which minimizes the sum of all numbers along it. Return this minimum sum. The direction of movement is limited to right and down.
// Example:
//
// Input Matrix :
//
//     1 2 3
//     4 5 6
//     7 8 9
//
// Output  : 21






// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static int minWeightedPath(int[][] grid) {
    int m = grid.length;
    int n = grid[m - 1].length;
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            if(i == 0 && j == 0){
                continue;
            }else if(i == 0){
                grid[i][j] += grid[i][j - 1];
            }else if(j == 0){
                grid[i][j] += grid[i - 1][j];
            }else{
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
    }
    return grid[m - 1][n - 1];

}
// Time : O(MN)
// Space : O(MN)
