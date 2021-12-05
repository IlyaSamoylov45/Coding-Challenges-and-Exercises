// Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
//
// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
//
//
//
// Example 1:
//
// Input: grid = [
//   ["1","1","1","1","0"],
//   ["1","1","0","1","0"],
//   ["1","1","0","0","0"],
//   ["0","0","0","0","0"]
// ]
// Output: 1
// Example 2:
//
// Input: grid = [
//   ["1","1","0","0","0"],
//   ["1","1","0","0","0"],
//   ["0","0","1","0","0"],
//   ["0","0","0","1","1"]
// ]
// Output: 3
//
//
// Constraints:
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 300
// grid[i][j] is '0' or '1'.





// DFS
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    removeIsland(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void removeIsland(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        removeIsland(grid, i + 1, j);
        removeIsland(grid, i - 1, j);
        removeIsland(grid, i, j + 1);
        removeIsland(grid, i, j - 1);


    }
}
// Time : O(NM)
// Space : O(NM)






// DFS
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int num_islands = 0;
        int height = grid.length;
        int width = grid[0].length;

        for(int row = 0; row < height; row++){
            for(int col = 0; col < width; col++){
                if(grid[row][col] == '1'){
                    num_islands++;
                    grid[row][col] = '0';

                    Stack<Integer> stack = new Stack<>();
                    stack.add(row * width + col);
                    while(!stack.isEmpty()){
                        int id = stack.pop();
                        int currRow = id/width;
                        int currCol = id % width;

                        if(currRow - 1 >= 0 && grid[currRow-1][currCol] == '1'){
                            stack.add((currRow - 1) * width + currCol);
                            grid[currRow - 1][currCol] = '0';
                        }
                        if(currRow + 1 < height && grid[currRow+1][currCol] == '1'){
                            stack.add((currRow + 1) * width + currCol);
                            grid[currRow + 1][currCol] = '0';
                        }
                        if(currCol - 1 >= 0 && grid[currRow][currCol - 1] == '1'){
                            stack.add(currRow * width + currCol - 1);
                            grid[currRow][currCol - 1] = '0';
                        }
                        if(currCol + 1 < width && grid[currRow][currCol + 1] == '1'){
                            stack.add(currRow * width + currCol + 1);
                            grid[currRow ][currCol + 1] = '0';
                        }
                    }
                }
            }
        }
        return num_islands;
    }

}






// BFS
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int num_islands = 0;
        int height = grid.length;
        int width = grid[0].length;

        for(int row = 0; row < height; row++){
            for(int col = 0; col < width; col++){
                if(grid[row][col] == '1'){
                    num_islands++;
                    grid[row][col] = '0';

                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(row * width + col);
                    while(!queue.isEmpty()){
                        int id = queue.remove();
                        int currRow = id/width;
                        int currCol = id % width;

                        if(currRow - 1 >= 0 && grid[currRow-1][currCol] == '1'){
                            queue.add((currRow - 1) * width + currCol);
                            grid[currRow - 1][currCol] = '0';
                        }
                        if(currRow + 1 < height && grid[currRow+1][currCol] == '1'){
                            queue.add((currRow + 1) * width + currCol);
                            grid[currRow + 1][currCol] = '0';
                        }
                        if(currCol - 1 >= 0 && grid[currRow][currCol - 1] == '1'){
                            queue.add(currRow * width + currCol - 1);
                            grid[currRow][currCol - 1] = '0';
                        }
                        if(currCol + 1 < width && grid[currRow][currCol + 1] == '1'){
                            queue.add(currRow * width + currCol + 1);
                            grid[currRow ][currCol + 1] = '0';
                        }
                    }
                }
            }
        }
        return num_islands;
    }

}
