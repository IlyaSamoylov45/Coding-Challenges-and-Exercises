// You're given a 2D Boggle Board which contains an m x n matrix of chars - char[][] board, and a fast, electronic Dictionary in the form of a Prefix Tree or Trie. Write a method - boggleSearchWithDict that searches the Boggle Board for words in the dictionary. Your method should return an alphabetically sorted ArrayList of words that are present on the board as well as in the dictionary. Words on the board can be constructed with sequentially adjacent letters, where adjacent letters are horizontal or vertical neighbors (not diagonal). Also, each letter on the Boggle Board must be used only once. Your program should run in a reasonable amount of time (at max about 50 ms for each test case) and shouldn't time out.
//
// Note: The Trie has two built-in methods that you'll find useful for this problem - searchWord(String s) and searchPrefix(String s). These will return true if the complete word or prefix are found in the dictionary, respectively.
//
// Example:
//
// Input Board :
// {
//     {A, O, L},
//     {D, E, L},
//     {G, H, I},
// }
// Dictionary : [HELLO, HOW, ARE, YOU] (as a Trie)
// Output: [HELLO]




// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public ArrayList<String> boggleSearchWithDict(char[][] board, Trie dictionary){
    Set<String> set = new TreeSet<>();
    for(int i = 0; i < board.length; i++){
        for(int j = 0; j < board[i].length; j++){
            boggleSearchWithDict(board, dictionary, i, j, set, new StringBuilder(""));
        }
    }
    return new ArrayList<>(set);
}

private void boggleSearchWithDict(char[][] board, Trie dictionary, int i, int j, Set<String> vals, StringBuilder sb){
    if(i < 0 || j < 0 || i >= board.length || j >= board[i].length || board[i][j] == '@' || !dictionary.searchPrefix(sb.toString())){
        return;
    }
    if(dictionary.searchWord(sb.toString())){
        vals.add(sb.toString());
    }
    sb.append(board[i][j]);
    char curr = board[i][j];
    board[i][j] = '@';
    boggleSearchWithDict(board, dictionary, i + 1, j, vals, sb);
    boggleSearchWithDict(board, dictionary, i, j + 1, vals, sb);
    boggleSearchWithDict(board, dictionary, i - 1, j, vals, sb);
    boggleSearchWithDict(board, dictionary, i, j - 1, vals, sb);
    sb.setLength(sb.length() - 1);
    board[i][j] = curr;

}
