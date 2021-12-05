// Given an m x n board of characters and a list of strings words, return all words on the board.
//
// Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
//
//
//
// Example 1:
//
//
// Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
// Output: ["eat","oath"]
// Example 2:
//
//
// Input: board = [["a","b"],["c","d"]], words = ["abcb"]
// Output: []
//
//
// Constraints:
//
// m == board.length
// n == board[i].length
// 1 <= m, n <= 12
// board[i][j] is a lowercase English letter.
// 1 <= words.length <= 3 * 104
// 1 <= words[i].length <= 10
// words[i] consists of lowercase English letters.
// All the strings of words are unique.






class Solution {
    TrieNode root = new TrieNode();
    Set<String> result = new HashSet<String>();

    public List<String> findWords(char[][] board, String[] words) {
        for(String word : words){
            insert(word);
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                search(board, i, j, root);
            }
        }

        return new ArrayList<>(result);
    }

    private void insert(String word){
        TrieNode current = root;
        for(char c : word.toCharArray()){
            if(!current.children.containsKey(c)){
                current.children.put(c, new TrieNode());
            }
            current = current.children.get(c);
        }
        current.word = word;
    }

    private void search(char[][] board, int i, int j, TrieNode current){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || !current.children.containsKey(board[i][j])){
            return;
        }
        TrieNode next = current.children.get(board[i][j]);
        if(next.word != null){
            result.add(next.word);
        }
        char temp = board[i][j];
        board[i][j] = '@';
        int[][] directions = {{0, 1},{0, -1},{1, 0},{-1, 0}};
        for(int[] direction : directions){
            search(board, i + direction[0], j + direction[1], next);
        }
        board[i][j] = temp;

    }

    class TrieNode{
        String word;
        Map<Character, TrieNode> children;
        public TrieNode(){
            this.children = new HashMap<>();
        }
    }


}
// Time : O(M(4*3^(L-1)))
// Space : O(N)
