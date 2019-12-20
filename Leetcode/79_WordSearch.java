/**
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.

**/
class Solution {
    public boolean exist(char[][] board, String word) {
        if(word == null || word.isEmpty()){
            return true;
        }
        char[] currWord = word.toCharArray();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(exist(board, currWord, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean exist(char[][] board, char[] word, int index, int i, int j){
        if(index >= word.length){
            return true;
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] == '@' || board[i][j] != word[index]){
            return false;
        }
        char curr = board[i][j];
        board[i][j] = '@';
        boolean val = exist(board, word, index + 1, i + 1, j) || exist(board, word, index + 1, i - 1, j) || exist(board, word, index + 1, i, j + 1) || exist(board, word, index + 1, i, j - 1);
        board[i][j] = curr;
        return val;
    }
}
