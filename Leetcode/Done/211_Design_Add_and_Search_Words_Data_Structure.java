// Design a data structure that supports adding new words and finding if a string matches any previously added string.
//
// Implement the WordDictionary class:
//
// WordDictionary() Initializes the object.
// void addWord(word) Adds word to the data structure, it can be matched later.
// bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
//
//
// Example:
//
// Input
// ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
// [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
// Output
// [null,null,null,null,false,true,true,true]
//
// Explanation
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("bad");
// wordDictionary.addWord("dad");
// wordDictionary.addWord("mad");
// wordDictionary.search("pad"); // return False
// wordDictionary.search("bad"); // return True
// wordDictionary.search(".ad"); // return True
// wordDictionary.search("b.."); // return True
//
//
// Constraints:
//
// 1 <= word.length <= 500
// word in addWord consists lower-case English letters.
// word in search consist of  '.' or lower-case English letters.
// At most 50000 calls will be made to addWord and search.







/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
class WordDictionary {

    private TrieNode root;

    class TrieNode{
        public boolean leaf;
        public Map<Character, TrieNode> children;

        public TrieNode(){
            this.children = new HashMap<>();
        }

    }

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        if(root == null){
            return;
        }
        TrieNode current = root;
        for(Character c : word.toCharArray()){
            if(!current.children.containsKey(c)){
                current.children.put(c, new TrieNode());
            }
            current = current.children.get(c);
        }
        current.leaf = true;
    }

    public boolean search(String word) {
        if(root == null){
            return false;
        }

        Stack<Pair<TrieNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 0));

        while(!stack.isEmpty()){
            Pair<TrieNode, Integer> pair = stack.pop();
            TrieNode current = pair.getKey();
            int position = pair.getValue();

            if(position >= word.length()){
                if(current.leaf){
                    return true;
                }
                continue;
            }

            Character c = word.charAt(position);

            if(!current.children.containsKey(c)){
                if(c == '.'){
                    for(Character entry : current.children.keySet()){
                        stack.push(new Pair<>(current.children.get(entry), position + 1 ));
                    }
                }

            }else {

                stack.push(new Pair<>(current.children.get(c), position + 1));
            }

        }
        return false;
    }
}
// Time : O(MN)
// Space : O(M)









class WordDictionary {

    private TrieNode root;

    class TrieNode{
        public boolean leaf;
        public Map<Character, TrieNode> children;

        public TrieNode(){
            this.children = new HashMap<>();
        }

    }

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        if(root == null){
            return;
        }
        TrieNode current = root;
        for(Character c : word.toCharArray()){
            if(!current.children.containsKey(c)){
                current.children.put(c, new TrieNode());
            }
            current = current.children.get(c);
        }
        current.leaf = true;
    }

    public boolean search(String word) {
        return searchHelper(root, word);
    }


    private boolean searchHelper(TrieNode node, String word){
        if(node == null){
            return false;
        }
        if(word.length() == 0){
            return node.leaf;
        }
        boolean seen = false;
        Character c = word.charAt(0);
        if(!node.children.containsKey(c)){
            if(c.equals('.')){
                for(Character entry : node.children.keySet()){
                    seen |= searchHelper(node.children.get(entry), word.substring(1));
                }
            }
        }else {
            seen |=searchHelper(node.children.get(c), word.substring(1));
        }
        return seen;

    }
}
// Time : O(MN)
// Space : O(M)







class WordDictionary {

    private TrieNode root;

    class TrieNode{
        public boolean leaf;
        public Map<Character, TrieNode> children;

        public TrieNode(){
            this.children = new HashMap<>();
        }

    }

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        if(root == null){
            return;
        }
        TrieNode current = root;
        for(Character c : word.toCharArray()){
            if(!current.children.containsKey(c)){
                current.children.put(c, new TrieNode());
            }
            current = current.children.get(c);
        }
        current.leaf = true;
    }

    public boolean search(String word) {
        return searchHelper(root, word);
    }


    private boolean searchHelper(TrieNode node, String word){
        for(int i = 0; i < word.length(); ++i){
            Character c = word.charAt(i);
            if(!node.children.containsKey(c)){
                if(c.equals('.')){
                    for(Character entry : node.children.keySet()){
                        if(searchHelper(node.children.get(entry), word.substring(i+1))){
                            return true;
                        }
                    }
                }
                return false;
            }else {
                node = node.children.get(c);
            }
        }
        return node.leaf;

    }
}
// Time : O(MN)
// Space : O(M)
