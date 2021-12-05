// A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
//
// Implement the Trie class:
//
// Trie() Initializes the trie object.
// void insert(String word) Inserts the string word into the trie.
// int countWordsEqualTo(String word) Returns the number of instances of the string word in the trie.
// int countWordsStartingWith(String prefix) Returns the number of strings in the trie that have the string prefix as a prefix.
// void erase(String word) Erases the string word from the trie.
//
//
// Example 1:
//
// Input
// ["Trie", "insert", "insert", "countWordsEqualTo", "countWordsStartingWith", "erase", "countWordsEqualTo", "countWordsStartingWith", "erase", "countWordsStartingWith"]
// [[], ["apple"], ["apple"], ["apple"], ["app"], ["apple"], ["apple"], ["app"], ["apple"], ["app"]]
// Output
// [null, null, null, 2, 2, null, 1, 1, null, 0]
//
// Explanation
// Trie trie = new Trie();
// trie.insert("apple");               // Inserts "apple".
// trie.insert("apple");               // Inserts another "apple".
// trie.countWordsEqualTo("apple");    // There are two instances of "apple" so return 2.
// trie.countWordsStartingWith("app"); // "app" is a prefix of "apple" so return 2.
// trie.erase("apple");                // Erases one "apple".
// trie.countWordsEqualTo("apple");    // Now there is only one instance of "apple" so return 1.
// trie.countWordsStartingWith("app"); // return 1
// trie.erase("apple");                // Erases "apple". Now the trie is empty.
// trie.countWordsStartingWith("app"); // return 0
//
//
// Constraints:
//
// 1 <= word.length, prefix.length <= 2000
// word and prefix consist only of lowercase English letters.
// At most 3 * 104 calls in total will be made to insert, countWordsEqualTo, countWordsStartingWith, and erase.
// It is guaranteed that for any function call to erase, the string word will exist in the trie.








/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */
class Trie {

    private TrieNode root;

    class TrieNode{
        private Map<Character, TrieNode> children;
        private Character c;
        private int count;

        public TrieNode(){
            this.children = new HashMap<>();
        }

        public TrieNode(Character c){
            this.children = new HashMap<>();
            this.c = c;
        }
    }

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for(Character c : word.toCharArray()){
            if(!current.children.containsKey(c)){
                current.children.put(c, new TrieNode(c));
            }
            current = current.children.get(c);
        }
        current.count++;
    }

    public int countWordsEqualTo(String word) {
        TrieNode current = getPrefix(word);
        return current != null ? current.count : 0;
    }

    public int countWordsStartingWith(String prefix) {
        TrieNode current = getPrefix(prefix);
        Stack<TrieNode> stack = new Stack<>();
        int count = 0;
        if(current != null){
            stack.push(current);
        }
        while(!stack.isEmpty()){
            current = stack.pop();
            count += current.count;
            current.children.forEach((key,value) -> stack.push(value));
        }
        return count;
    }

    public TrieNode getPrefix(String word){
        TrieNode current = root;
        for(Character c : word.toCharArray()){
            if(!current.children.containsKey(c)){
                return null;
            }
            current = current.children.get(c);
        }
        return current;
    }
    
    public void erase(String word) {
        TrieNode current = root;
        Stack<TrieNode> stack = new Stack<>();
        for(Character c : word.toCharArray()){
            if(!current.children.containsKey(c)){
                return;
            }
            stack.push(current);
            current = current.children.get(c);
        }
        int count = --current.count;
        while(!stack.isEmpty() && count == 0 && current.children.size() == 0){
            TrieNode pre = stack.pop();
            pre.children.remove(current.c);
            count = pre.count;
            current = pre;
        }
    }
}
// Time : O(K * N)
// Space O(K * N)
