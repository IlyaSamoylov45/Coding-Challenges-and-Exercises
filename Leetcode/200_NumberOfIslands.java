/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
*/

class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1'){
                    count++;
                    numIslandsSupport(grid, i, j, n, m);
                }
            }
        }
        return count;
    }

    public void numIslandsSupport(char[][] grid, int i, int j, int n, int m){
        if(i < 0 || i >= n || j < 0 || j >= m || grid[i][j] != '1'){
            return;
        }
        grid[i][j] = '0';
        numIslandsSupport(grid, i+1, j, n, m);
        numIslandsSupport(grid, i-1, j, n, m);
        numIslandsSupport(grid, i, j+1, n, m);
        numIslandsSupport(grid, i, j-1, n, m);
    }
}
