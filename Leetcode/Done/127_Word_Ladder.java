// A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
//
// Every adjacent pair of words differs by a single letter.
// Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
// sk == endWord
// Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
//
//
//
// Example 1:
//
// Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
// Output: 5
// Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
// Example 2:
//
// Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
// Output: 0
// Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
//
//
// Constraints:
//
// 1 <= beginWord.length <= 10
// endWord.length == beginWord.length
// 1 <= wordList.length <= 5000
// wordList[i].length == beginWord.length
// beginWord, endWord, and wordList[i] consist of lowercase English letters.
// beginWord != endWord
// All the words in wordList are unique.







class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        for(String word : wordList){
            words.add(word);
        }
        queue.offer(beginWord);
        words.remove(beginWord);
        int count = 0;
        while(!queue.isEmpty()){
            count++;
            int size = queue.size();
            while(size-- > 0){
                String word = queue.remove();
                if(word.equals(endWord)){
                    return count;
                }
                List<String> neighbors = getNeighbors(word);
                for(String neighbor : neighbors){
                    if(words.contains(neighbor)){
                        words.remove(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return 0;
    }

    private List<String> getNeighbors(String word){
        char[] letters = word.toCharArray();
        List<String> neighbors = new ArrayList<>();
        for(int i = 0; i < word.length(); i++){
            char temp = letters[i];
            for(char c = 'a'; c <= 'z'; c++){
                letters[i] = c;
                String neighbor = new String(letters);
                neighbors.add(neighbor);
            }
            letters[i] = temp;
        }
        return neighbors;
    }
}
// Time : O(M^2 * N)
// Space : O(M^2 * N)
