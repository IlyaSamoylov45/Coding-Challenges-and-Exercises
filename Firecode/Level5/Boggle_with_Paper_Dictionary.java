// You're given a 2D Boggle Board which contains an m x n matrix of chars - char[][] board, and a rudimentary, paper Dictionary in the form of an ArrayList of close to 10,000 words. Write a method - boggleByot that searches the Boggle Board for words in the dictionary. Your method should return an alphabetically sorted ArrayList of words that are present on the board as well as in the dictionary. Words on the board can be constructed with sequentially adjacent letters, where adjacent letters are horizontal or vertical neighbors (not diagonal). Also, each letter on the Boggle Board must be used only once.
//
// Note:
// Your program should run in a reasonable amount of time - about a few milliseconds for each test case.
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

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.
class Trie{
    public TrieNode root;
    public Trie(){
        this.root = new TrieNode();
    }

    public void insertWord(String word){
        if(word == null || word.length() == 0){
            return;
        }
        TrieNode current = root;
        for(Character c : word.toCharArray()){

            if(!current.children.containsKey(c)){
                current.children.put(c, new TrieNode(c));
            }

            current = current.children.get(c);
        }
        current.isLeaf = true;
    }

    public boolean searchWord(String word){
        if(word == null || word.length() == 0){
            return false;
        }
        TrieNode current = root;
        for(Character c : word.toCharArray()){

            if(!current.children.containsKey(c)){
                return false;
            }

            current = current.children.get(c);
        }
        return current.isLeaf;

    }

    public boolean searchPrefix(String word){
        if(word == null || word.length() == 0){
            return false;
        }
        TrieNode current = root;
        for(Character c : word.toCharArray()){
            if(!current.children.containsKey(c)){
                return false;
            }
            current = current.children.get(c);
        }
        return true;
    }
}

class TrieNode{
    public Character c;
    public boolean isLeaf;
    public Map<Character, TrieNode> children;

    public TrieNode(){
        this.children = new HashMap<>();
    }

    public TrieNode(Character c){
        this.c = c;
        this.children = new HashMap<>();
    }
}

public ArrayList<String> boggleByot(char[][] board, ArrayList<String> dictionary){
    Set<String> words = new TreeSet<>();
    Trie trie = new Trie();

    for(String word : dictionary){
        trie.insertWord(word);
    }

    for(int i = 0; i < board.length; i++){
        for(int j = 0; j < board[i].length; j++){
            boggleByot(board, words, trie, i, j, "");
        }
    }
    return new ArrayList<>(words);
}

public void boggleByot(char[][] board, Set<String> words, Trie root, int i, int j, String current){
    if(i < 0 || j < 0 || i >= board.length || j >= board[i].length || board[i][j] == '@'){
        return;
    }
    char c = board[i][j];
    String s = current + c;
    if(!root.searchPrefix(s)){
        return;
    }
    board[i][j] = '@';
    if(root.searchWord(s)){
        words.add(s);
    }
    boggleByot(board, words, root, i + 1, j, s);
    boggleByot(board, words, root, i - 1, j, s);
    boggleByot(board, words, root, i, j + 1, s);
    boggleByot(board, words, root, i, j - 1, s);
    board[i][j] = c;

}
