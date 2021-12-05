// Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.
//
// A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
//
// All the visited cells of the path are 0.
// All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
// The length of a clear path is the number of visited cells of this path.
//
//
//
// Example 1:
//
//
// Input: grid = [[0,1],[1,0]]
// Output: 2
// Example 2:
//
//
// Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
// Output: 4
// Example 3:
//
// Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
// Output: -1
//
//
// Constraints:
//
// n == grid.length
// n == grid[i].length
// 1 <= n <= 100
// grid[i][j] is 0 or 1






class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] != 0){
            return -1;
        }
        int n = grid.length - 1;
        int m = grid[0].length - 1;
        int[][] dirs = {{1,0}, {0,1}, {1,1}, {-1,-1}, {-1,0}, {0,-1}, {-1,1}, {1,-1}};
        Queue<int[]> queue = new LinkedList<>();
        grid[0][0] = -1;
        queue.offer(new int[]{0, 0});
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int[] curr = queue.remove();
                if(curr[0] == n && curr[1] == m){
                    return Math.abs(grid[n][m]);
                }
                for(int[] dir : dirs){
                    if(isValid(grid, curr[0] + dir[0], curr[1] + dir[1])){              
                        queue.offer(new int[]{curr[0] + dir[0], curr[1] + dir[1]});
                        grid[curr[0] + dir[0]][curr[1] + dir[1]] = grid[curr[0]][curr[1]] - 1;
                    }
                }

            }

        }
        return -1;
    }

    private boolean isValid(int[][] grid, int i, int j){
        return i >= 0 && j >= 0 && i < grid.length && j < grid[i].length && grid[i][j] == 0;
    }
}
// Time : O(N)
// Space : O(N)
