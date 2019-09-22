/*
You are given an array of strings words and a string chars.

A string is good if it can be formed by characters from chars (each character can only be used once).

Return the sum of lengths of all good strings in words.



Example 1:

Input: words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6
Explanation:
The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
Example 2:

Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
Output: 10
Explanation:
The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.


Note:

1 <= words.length <= 1000
1 <= words[i].length, chars.length <= 100
All strings contain lowercase English letters only.
*/

class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] vals = new int[26];
        int count = 0;
        for(char c : chars.toCharArray()){
            vals[c-'a']++;
        }
        for(int i = 0; i < words.length; i++){
            count += countCharactersSupport(words[i], vals, 0);
        }
        return count;
    }

    public int countCharactersSupport(String word, int[] vals, int j){
        if(j >= word.length()){
            return word.length();
        }
        char c = word.charAt(j);
        if(--vals[c - 'a'] < 0){
            vals[c - 'a']++;
            return 0;
        }
        int curr = countCharactersSupport(word, vals, j+1);
        vals[c - 'a']++;
        return curr;
    }
}
