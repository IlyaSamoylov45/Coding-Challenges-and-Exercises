// In English, we have a concept called root, which can be followed by some other word to form another longer word - let's call this word successor. For example, when the root "an" is followed by the successor word "other", we can form a new word "another".
//
// Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces, replace all the successors in the sentence with the root forming it. If a successor can be replaced by more than one root, replace it with the root that has the shortest length.
//
// Return the sentence after the replacement.
//
//
//
// Example 1:
//
// Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
// Output: "the cat was rat by the bat"
// Example 2:
//
// Input: dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
// Output: "a a b c"
// Example 3:
//
// Input: dictionary = ["a", "aa", "aaa", "aaaa"], sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"
// Output: "a a a a a a a a bbb baba a"
// Example 4:
//
// Input: dictionary = ["catt","cat","bat","rat"], sentence = "the cattle was rattled by the battery"
// Output: "the cat was rat by the bat"
// Example 5:
//
// Input: dictionary = ["ac","ab"], sentence = "it is abnormal that this solution is accepted"
// Output: "it is ab that this solution is ac"
//
//
// Constraints:
//
// 1 <= dictionary.length <= 1000
// 1 <= dictionary[i].length <= 100
// dictionary[i] consists of only lower-case letters.
// 1 <= sentence.length <= 10^6
// sentence consists of only lower-case letters and spaces.
// The number of words in sentence is in the range [1, 1000]
// The length of each word in sentence is in the range [1, 1000]
// Each two consecutive words in sentence will be separated by exactly one space.
// sentence does not have leading or trailing spaces.







class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> set = new HashSet();
        for (String word: dictionary){
            set.add(word);
        }

        StringBuilder sb = new StringBuilder();
        String prefix = "";
        for(String word: sentence.split(" ")){
            int i = 0;
            for (; i < word.length(); i++) {
                if(set.contains(word.substring(0, i))){
                    break;
                }
            }
            sb.append(prefix + word.substring(0, i));
            prefix = " ";
        }
        return sb.toString();
    }
}
// Time : O(w^2)
// Space : O(N)





class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for(String word : dictionary){
            trie.insertWord(word);
        }
        StringBuilder sb = new StringBuilder();
        String prefix = "";
        for(String word : sentence.split(" ")){
            int i = 0;
            while(i < word.length() && !trie.searchWord(word.substring(0,i))){
                i++;
            }
            sb.append(prefix + word.substring(0, i));
            prefix = " ";
        }
        return sb.toString();
    }

    class TrieNode {
        Character c;
        boolean isLeaf = false;
        HashMap<Character, TrieNode> children = new HashMap<>();
        public TrieNode() {}
        public TrieNode(Character c) {
            this.c = c;
        }
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insertWord(String word) {
            if (word == null || word.length() == 0) {
                return;
            }
            TrieNode curr = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(curr.children.containsKey(c)){
                    curr = curr.children.get(c);
                }else{
                    curr.children.put(c, new TrieNode(c));
                    curr = curr.children.get(c);
                }
            }
            curr.isLeaf = true;
        }

        public Boolean searchWord(String word) {
            TrieNode curr = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(curr.children.containsKey(c)){
                    curr = curr.children.get(c);
                }else{
                    return false;
                }
            }
            return curr.isLeaf;
        }
    }
}
// Time : O(N)
// Space : O(N)








class Solution {
    public String replaceWords(List<String> roots, String sentence) {
        TrieNode trie = new TrieNode();
        for (String root: roots) {
            TrieNode cur = trie;
            for (char letter: root.toCharArray()) {
                if (cur.children[letter - 'a'] == null)
                    cur.children[letter - 'a'] = new TrieNode();
                cur = cur.children[letter - 'a'];
            }
            cur.word = root;
        }

        StringBuilder ans = new StringBuilder();

        for (String word: sentence.split("\\s+")) {
            if (ans.length() > 0)
                ans.append(" ");

            TrieNode cur = trie;
            for (char letter: word.toCharArray()) {
                if (cur.children[letter - 'a'] == null || cur.word != null)
                    break;
                cur = cur.children[letter - 'a'];
            }
            ans.append(cur.word != null ? cur.word : word);
        }
        return ans.toString();
    }
}

class TrieNode {
    TrieNode[] children;
    String word;
    TrieNode() {
        children = new TrieNode[26];
    }
}
// Time : O(N)
// Space : O(N)
