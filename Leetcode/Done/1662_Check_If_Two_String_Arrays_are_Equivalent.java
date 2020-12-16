// Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.
//
// A string is represented by an array if the array elements concatenated in order forms the string.
//
//
//
// Example 1:
//
// Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
// Output: true
// Explanation:
// word1 represents string "ab" + "c" -> "abc"
// word2 represents string "a" + "bc" -> "abc"
// The strings are the same, so return true.
// Example 2:
//
// Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
// Output: false
// Example 3:
//
// Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
// Output: true
//
//
// Constraints:
//
// 1 <= word1.length, word2.length <= 103
// 1 <= word1[i].length, word2[i].length <= 103
// 1 <= sum(word1[i].length), sum(word2[i].length) <= 103
// word1[i] and word2[i] consist of lowercase letters.





class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i = 0;
        int j = 0;
        int w1 = 0;
        int w2 = 0;
        while(i < word1.length && j < word2.length){
            while(w1 < word1[i].length() && w2 < word2[j].length()){
                if(word1[i].charAt(w1) != word2[j].charAt(w2)){
                    return false;
                }
                w1++;
                w2++;
            }

            if(w1 == word1[i].length()){
                w1 = 0;
                i++;
            }
            if(w2 == word2[j].length()){
                w2 = 0;
                j++;
            }
        }
        return w1 == w2;
    }
}
// Time : O(MIN(N, M))
// Space : O(1)
