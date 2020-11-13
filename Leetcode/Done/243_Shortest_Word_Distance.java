// Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
//
// Example:
// Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
//
// Input: word1 = “coding”, word2 = “practice”
// Output: 3
// Input: word1 = "makes", word2 = "coding"
// Output: 1
// Note:
// You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.



class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int shortest = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1)){
                index1 = i;
                if(index1 != -1 && index2 != -1){
                    shortest = Math.min(index1-index2, shortest);
                }
            }else if(words[i].equals(word2)){
                index2 = i;
                if(index1 != -1 && index2 != -1){
                    shortest = Math.min(index2-index1, shortest);
                }
            }
        }
        return shortest;
    }
}
// Time : O(N)
// Space : O(1)





class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int shortest = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1)){
                index1 = i;
            }else if(words[i].equals(word2)){
                index2 = i;
            }
            if(index1 != -1 && index2 != -1){
                shortest = Math.min(Math.abs(index1-index2), shortest);
            }
        }
        return shortest;
    }
}
// Time : O(N)
// Space : O(1)
