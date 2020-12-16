// You're given a 2D Boggle Board which contains an m x n matrix of chars - char[][] board, and a String - word. Write a method - boggleSearch that searches the Boggle Board for the presence of the input word. Words on the board can be constructed with sequentially adjacent letters, where adjacent letters are horizontal or vertical neighbors (not diagonal). Also, each letter on the Boggle Board must be used only once.
//
// Example:
//
// Input Board :
// {
//     {A, O, L},
//     {D, E, L},
//     {G, H, I},
// }
// Word: "HELLO"
// Output: true



// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static boolean boggleSearch(char[][] board, String word){
    for(int i = 0; i < board.length; i++){
        for(int j = 0; j < board[i].length; j++){
            if(boggleSearch(board, word, i, j, 0)){
                return true;
            }
        }
    }
    return false;
}

private static boolean boggleSearch(char[][] board, String word, int i, int j, int pos){
    if(i < 0 || j < 0 || i >= board.length || j >= board[i].length || board[i][j] == '@' || pos >= word.length() || board[i][j] != word.charAt(pos)){
        return false;
    }
    if(pos == word.length() - 1){
        return true;
    }
    pos++;
    char c = board[i][j];
    board[i][j] = '@';
    boolean seen = boggleSearch(board, word, i + 1, j, pos) || boggleSearch(board, word, i, j + 1, pos) || boggleSearch(board, word, i - 1, j, pos) || boggleSearch(board, word, i, j - 1, pos);
    board[i][j] = c;
    return seen;
}
