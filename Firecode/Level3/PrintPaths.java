/*
You're given a 2D board which contains an m x n matrix of chars - char[][] board. Write a method - printPaths that prints all possible paths from the top left cell to the bottom right cell. Your method should return an ArrayList of Strings, where each String represents a path with characters appended in the order of movement. You're only allowed to move down and right on the board. The order of String insertion in the ArrayList does not matter.

Example:

Input Board :
{
    {A, X},
    {D, E}
}
Output: ["ADE", "AXE"]
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public ArrayList<String> printPaths(char[][] board){
    ArrayList<String> vals = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    printPathsSupport(board, 0, 0, sb, vals);
    return vals;
}

public void printPathsSupport(char[][] board, int i, int j, StringBuilder sb, ArrayList<String> vals){
    if(i >= board.length || j >= board[i].length){
        return;
    }
    sb.append(board[i][j]);
    if(i == board.length - 1 && j == board[i].length - 1){
        vals.add(sb.toString());
        sb.setLength(sb.length() - 1);
        return;
    }
    printPathsSupport(board, i+1, j, sb, vals);
    printPathsSupport(board, i, j+1, sb, vals);
    sb.setLength(sb.length() - 1);
}
