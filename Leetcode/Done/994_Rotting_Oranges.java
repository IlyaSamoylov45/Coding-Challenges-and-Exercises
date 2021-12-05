// You are given an m x n grid where each cell can have one of three values:
//
// 0 representing an empty cell,
// 1 representing a fresh orange, or
// 2 representing a rotten orange.
// Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
//
// Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
//
//
//
// Example 1:
//
//
// Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
// Output: 4
// Example 2:
//
// Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
// Output: -1
// Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
// Example 3:
//
// Input: grid = [[0,2]]
// Output: 0
// Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
//
//
// Constraints:
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 10
// grid[i][j] is 0, 1, or 2.





class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                    grid[i][j] = 0;
                }
            }
        }
        int duration = rotting(grid, queue);

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return duration;
    }

    private int rotting(int[][] grid, Queue<int[]> queue){
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int[] position = queue.poll();
                int currX = position[0];
                int currY = position[1];
                int[][] directions = {{0, 1},{1, 0},{0, -1},{-1, 0}};
                for(int[] direction : directions){
                    int x = direction[0] + position[0];
                    int y = direction[1] + position[1];
                    if(validDirection(grid, x, y)){
                        queue.offer(new int[]{ x,  y});
                        grid[x][y] = 2;
                    }
                }
            }
            if(!queue.isEmpty()){
                count++;
            }
        }
        return count;
    }

    private boolean validDirection(int[][] grid, int x, int y){
        return x >= 0 && y >= 0 && x < grid.length && y < grid[x].length && grid[x][y] == 1;
    }
}
// Time : O(N*M)
// Space : O(N)
