// On an 8 x 8 chessboard, there is one white rook.  There also may be empty squares, white bishops, and black pawns.  These are given as characters 'R', '.', 'B', and 'p' respectively. Uppercase characters represent white pieces, and lowercase characters represent black pieces.
//
// The rook moves as in the rules of Chess: it chooses one of four cardinal directions (north, east, west, and south), then moves in that direction until it chooses to stop, reaches the edge of the board, or captures an opposite colored pawn by moving to the same square it occupies.  Also, rooks cannot move into the same square as other friendly bishops.
//
// Return the number of pawns the rook can capture in one move.
//
//
//
// Example 1:
//
//
//
// Input: [[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","R",".",".",".","p"],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
// Output: 3
// Explanation:
// In this example the rook is able to capture all the pawns.
// Example 2:
//
//
//
// Input: [[".",".",".",".",".",".",".","."],[".","p","p","p","p","p",".","."],[".","p","p","B","p","p",".","."],[".","p","B","R","B","p",".","."],[".","p","p","B","p","p",".","."],[".","p","p","p","p","p",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
// Output: 0
// Explanation:
// Bishops are blocking the rook to capture any pawn.
// Example 3:
//
//
//
// Input: [[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","p",".",".",".","."],["p","p",".","R",".","p","B","."],[".",".",".",".",".",".",".","."],[".",".",".","B",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."]]
// Output: 3
// Explanation:
// The rook can capture the pawns at positions b5, d6 and f5.
//
//
// Note:
//
// board.length == board[i].length == 8
// board[i][j] is either 'R', '.', 'B', or 'p'
// There is exactly one cell with board[i][j] == 'R'






class Solution {
    public int numRookCaptures(char[][] board) {
        int count = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == 'R'){
                    count = checkCaptures(board, i, j);
                }
            }
        }
        return count;
    }

    public int checkCaptures(char[][] board, int i, int j){
        int count = 0;
        for(int x = i+1; x < board.length; x++){
            char c = board[x][j];
            if(c != '.'){
                if(c == 'p'){
                    count++;
                }
                break;
            }
        }

        for(int x = i-1; x >= 0; x--){
            char c = board[x][j];
            if(c != '.'){
                if(c == 'p'){
                    count++;
                }
                break;
            }
        }

        for(int x = j+1; x < board.length; x++){
            char c = board[i][x];
            if(c != '.'){
                if(c == 'p'){
                    count++;
                }
                break;
            }
        }

        for(int x = j-1; x >= 0; x--){
            char c = board[i][x];
            if(c != '.'){
                if(c == 'p'){
                    count++;
                }
                break;
            }
        }

        return count;

    }
}
// Time : O(N) ~= O(64)
// Space : O(1)






class Solution {
    public int numRookCaptures(char[][] board) {
        int x = -1;
        int y = -1;
        int n = board.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'R'){
                    y = i;
                    x = j;
                    break;
                }
            }
        }

        for(int[] dir : new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}){
            for(int i = y + dir[0], j = x + dir[1]; i < n && i >= 0 && j < n && j >= 0; i += dir[0],  j += dir[1]){
                char c = board[i][j];
                if(c == 'p'){
                    count++;
                }
                if(c != '.'){
                    break;
                }
            }
        }
        return count;
    }
}
// Time : O(N) ~= O(64)
// Space : O(1)
