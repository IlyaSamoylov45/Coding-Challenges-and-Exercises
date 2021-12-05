// There is a ball in a maze with empty spaces (represented as 0) and walls (represented as 1). The ball can go through the empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
//
// Given the m x n maze, the ball's start position and the destination, where start = [startrow, startcol] and destination = [destinationrow, destinationcol], return true if the ball can stop at the destination, otherwise return false.
//
// You may assume that the borders of the maze are all walls (see examples).
//
//
//
// Example 1:
//
//
// Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [4,4]
// Output: true
// Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.
// Example 2:
//
//
// Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [3,2]
// Output: false
// Explanation: There is no way for the ball to stop at the destination. Notice that you can pass through the destination but you cannot stop there.
// Example 3:
//
// Input: maze = [[0,0,0,0,0],[1,1,0,0,1],[0,0,0,0,0],[0,1,0,0,1],[0,1,0,0,0]], start = [4,3], destination = [0,1]
// Output: false
//
//
// Constraints:
//
// m == maze.length
// n == maze[i].length
// 1 <= m, n <= 100
// maze[i][j] is 0 or 1.
// start.length == 2
// destination.length == 2
// 0 <= startrow, destinationrow <= m
// 0 <= startcol, destinationcol <= n
// Both the ball and the destination exist in an empty space, and they will not be in the same position initially.
// The maze contains at least 2 empty spaces.






class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        return isValid(maze, start, destination);

    }

    private boolean isValid(int[][] maze, int[] start, int[] destination){
        if(maze[start[0]][start[1]] == -1){
            return false;
        }
        if(start[0] == destination[0] && start[1] == destination[1]){
            return true;
        }

        maze[start[0]][start[1]] = -1;
        int r = start[1] + 1;
        int l = start[1] - 1;
        int u = start[0] - 1;
        int d = start[0] + 1;

        while(r < maze[0].length && maze[start[0]][r] != 1){
            r++;
        }

        if(isValid(maze, new int[]{start[0], r - 1}, destination)){
            return true;
        }

        while(l >= 0 && maze[start[0]][l] != 1){
            l--;
        }

        if(isValid(maze, new int[]{start[0], l + 1}, destination)){
            return true;
        }

        while(u >= 0 && maze[u][start[1]] != 1){
            u--;
        }

        if(isValid(maze, new int[]{u + 1, start[1]}, destination)){
            return true;
        }

        while(d < maze.length && maze[d][start[1]] != 1){
            d++;
        }

        if(isValid(maze, new int[]{d - 1, start[1]}, destination)){
            return true;
        }

        return false;
    }
}
// Time : O(MN)
// Space : O(MN)






class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        int[][] dirs={{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        maze[start[0]][start[1]] = -1;
        while(!queue.isEmpty()){

            int[] current = queue.remove();
            if(current[0] == destination[0] && current[1] == destination[1]){
                return true;
            }

            for(int[] dir : dirs){
                int x = current[0] + dir[0];
                int y = current[1] + dir[1];
                while(isValid(maze, x, y)){
                    x += dir[0];
                    y += dir[1];
                }

                if(maze[x - dir[0]][y - dir[1]] != -1){
                    queue.add(new int[]{x - dir[0], y - dir[1]});
                    maze[x - dir[0]][y - dir[1]] = -1;
                }
            }

        }

        return false;
    }

    private boolean isValid(int[][] maze, int i, int j){
        return i >= 0 && j >= 0 && i < maze.length && j < maze[i].length && maze[i][j] != 1;
    }

}
// Time : O(MN)
// Space : O(MN)
