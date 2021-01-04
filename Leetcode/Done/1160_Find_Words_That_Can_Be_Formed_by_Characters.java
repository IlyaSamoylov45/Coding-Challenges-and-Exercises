// You are given an array of strings words and a string chars.
//
// A string is good if it can be formed by characters from chars (each character can only be used once).
//
// Return the sum of lengths of all good strings in words.
//
//
//
// Example 1:
//
// Input: words = ["cat","bt","hat","tree"], chars = "atach"
// Output: 6
// Explanation:
// The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
// Example 2:
//
// Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
// Output: 10
// Explanation:
// The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
//
//
// Note:
//
// 1 <= words.length <= 1000
// 1 <= words[i].length, chars.length <= 100
// All strings contain lowercase English letters only.







class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] letters = new int[26];
        int count = 0;
        for(char c : chars.toCharArray()){
            letters[c - 'a']++;
        }
        for(String word : words){
            int[] current = new int[26];
            int i = 0;
            for(i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(++current[c - 'a'] > letters[c - 'a']){
                    break;
                }
            }
            if(i == word.length()){
                count += word.length();
            }
        }
        return count;
    }
}
// Time : O(N)
// Space : O(1)
