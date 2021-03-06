// Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
//
// word1 and word2 may be the same and they represent two individual words in the list.
//
// Example:
// Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
//
// Input: word1 = “makes”, word2 = “coding”
// Output: 1
// Input: word1 = "makes", word2 = "makes"
// Output: 3
// Note:
// You may assume word1 and word2 are both in the list.

class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int index = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++){
            if (words[i].equals(word1) || words[i].equals(word2)) {
                if (index != -1 && (word1.equals(word2) || !words[index].equals(words[i]))) {
                    min = Math.min(i - index, min);
                }
                index = i;
            }
        }
        return min;
    }
}
// Time : O(N)
// Space : O(1)
