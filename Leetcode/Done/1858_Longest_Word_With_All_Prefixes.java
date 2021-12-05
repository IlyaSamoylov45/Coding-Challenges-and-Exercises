// Given an array of strings words, find the longest string in words such that every prefix of it is also in words.
//
// For example, let words = ["a", "app", "ap"]. The string "app" has prefixes "ap" and "a", all of which are in words.
// Return the string described above. If there is more than one string with the same length, return the lexicographically smallest one, and if no string exists, return "".
//
//
//
// Example 1:
//
// Input: words = ["k","ki","kir","kira", "kiran"]
// Output: "kiran"
// Explanation: "kiran" has prefixes "kira", "kir", "ki", and "k", and all of them appear in words.
// Example 2:
//
// Input: words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
// Output: "apple"
// Explanation: Both "apple" and "apply" have all their prefixes in words.
// However, "apple" is lexicographically smaller, so we return that.
// Example 3:
//
// Input: words = ["abc", "bc", "ab", "qwe"]
// Output: ""
//
//
// Constraints:
//
// 1 <= words.length <= 10^5
// 1 <= words[i].length <= 10^5
// 1 <= sum(words[i].length) <= 10^5





class Solution {
    TrieNode root = new TrieNode();
    String result = "";
    public String longestWord(String[] words) {
        for(String word : words){
            insert(word);
        }
        for(String word : words){
            searchPrefix(word);
        }
        return result;
    }

    public void searchPrefix(String word) {
        TrieNode current = root;
        for (Character c : word.toCharArray()) {
            current = current.children.get(c);
            if (!current.isLeaf){
                return;
            }
        }
        if (result.length() < word.length() ||
            result.length() == word.length() &&
            result.compareTo(word) > 0){
            result = word;
        }
    }

    public void insert(String word){
        TrieNode current = root;
        for(Character c : word.toCharArray()){
            if(!current.children.containsKey(c)){
                current.children.put(c, new TrieNode(c));
            }
            current = current.children.get(c);
        }
        current.isLeaf = true;
    }

    class TrieNode{
        Map<Character, TrieNode> children;
        boolean isLeaf;
        Character c;

        public TrieNode(){
            this.children = new HashMap<>();
        }

        public TrieNode(Character c){
            this.children = new HashMap<>();
            this.c = c;
            this.isLeaf = false;
        }

    }
}
// Time : O(N)
// Space : O(N)
