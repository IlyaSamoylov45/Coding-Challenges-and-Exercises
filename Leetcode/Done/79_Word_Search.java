// Given a 2D board and a word, find if the word exists in the grid.
//
// The word can be constructed from letters of sequentially adjacent cells, where "adjacent" cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
//
//
//
// Example 1:
//
//
// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
// Output: true
// Example 2:
//
//
// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
// Output: true
// Example 3:
//
//
// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
// Output: false
//
//
// Constraints:
//
// board and word consists only of lowercase and uppercase English letters.
// 1 <= board.length <= 200
// 1 <= board[i].length <= 200
// 1 <= word.length <= 10^3



class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(exist(board, word, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, int start, int i, int j){
        if(start >= word.length()){
            return true;
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(start)){
            return false;
        }
        char c = board[i][j];
        board[i][j] = '@';
        boolean found = exist(board, word, start + 1, i + 1, j) ||
                        exist(board, word, start + 1, i - 1, j) ||
                        exist(board, word, start + 1, i, j + 1) ||
                        exist(board, word, start + 1, i, j - 1);
        board[i][j] = c;
        return found;
    }
}
// Time Complexity: O(N⋅3^L) where N is the number of cells in the board and L is the length of the word to be matched.
// Space Complexity: O(L) where L is the length of the word to be matched.
