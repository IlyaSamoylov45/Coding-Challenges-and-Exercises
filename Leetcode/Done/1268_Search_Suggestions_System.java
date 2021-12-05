// Given an array of strings products and a string searchWord. We want to design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with the searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.
//
// Return list of lists of the suggested products after each character of searchWord is typed.
//
//
//
// Example 1:
//
// Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
// Output: [
// ["mobile","moneypot","monitor"],
// ["mobile","moneypot","monitor"],
// ["mouse","mousepad"],
// ["mouse","mousepad"],
// ["mouse","mousepad"]
// ]
// Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
// After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
// After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
// Example 2:
//
// Input: products = ["havana"], searchWord = "havana"
// Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
// Example 3:
//
// Input: products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
// Output: [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
// Example 4:
//
// Input: products = ["havana"], searchWord = "tatiana"
// Output: [[],[],[],[],[],[],[]]
//
//
// Constraints:
//
// 1 <= products.length <= 1000
// There are no repeated elements in products.
// 1 <= Σ products[i].length <= 2 * 10^4
// All characters of products[i] are lower-case English letters.
// 1 <= searchWord.length <= 1000
// All characters of searchWord are lower-case English letters.






class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> words = new ArrayList<>();
        if(searchWord == null){
            return words;
        }
        Trie trie = new Trie();
        for(String product : products){
            trie.insert(product);
        }
        for(int i = 1; i <= searchWord.length(); i++){
            List<String> result = trie.getWordsStartingWithPrefix(searchWord.substring(0, i));
            words.add(result);
        }
        return words;
    }

    class Trie {
        TrieNode root;

        class TrieNode{
            Map<Character, TrieNode> children;
            String word;
            public TrieNode(){
                this.children = new HashMap<>();
            }
        }

        public Trie(){
            this.root = new TrieNode();
        }

        public void insert(String word){
            TrieNode current = root;
            for(char c : word.toCharArray()){
                if(!current.children.containsKey(c)){
                    current.children.put(c, new TrieNode());
                }
                current = current.children.get(c);
            }
            current.word=word;
        }

        public List<String> getWordsStartingWithPrefix(String prefix){
            TrieNode current = root;
            List<String> result = new ArrayList<>();
            for(char c : prefix.toCharArray()){
                if(!current.children.containsKey(c)){
                    return result;
                }
                current = current.children.get(c);
            }
            dfsWithPrefix(current, result);
            return result;
        }

        public void dfsWithPrefix(TrieNode current, List<String> result){
            if(result.size() >= 3){
                return;
            }
            if(current.word != null){
                result.add(current.word);
            }
            for(char c = 'a'; c <= 'z'; c++){
                if (current.children.get(c) != null){
                    dfsWithPrefix( current.children.get(c), result);
                }
            }

        }
    }
}
// Time : O(M)
//        O(M) to build the trie where M is total number of characters in products For each prefix we find its representative node in O(len(prefix))
//        and dfs to find at most 3 words which is an O(1) operation. Thus the overall complexity is dominated by the time required to build the trie.
// Space : O(26N) = O(N)
//
