// Given an m x n matrix filled with non-negative integers, use depth first search to find the maximum sum along a path from the top-left of the grid to the bottom-right. Return this maximum sum. The direction of movement is limited to right and down.
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
// This problem has a more efficient solution based on Dynamic Programming techniques. We'll be exploring those in future problems - so don't fret just yet!



// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static int matrixMaxSumDfs(int[][] grid) {
    return matrixMaxSumDfs(grid, 0, 0);
}

private static int matrixMaxSumDfs(int[][] grid, int i, int j){
    if(i < 0 || j < 0 || i >= grid.length || j >=grid[i].length){
        return 0;
    }
    if(grid.length - 1 == i && grid[i].length - 1 == j){
        return grid[i][j];
    }
    return Math.max(matrixMaxSumDfs(grid, i + 1, j ), matrixMaxSumDfs(grid, i, j+ 1)) + grid[i][j];
}
// Time : O(b^NM)
// Space : O(bNM)
