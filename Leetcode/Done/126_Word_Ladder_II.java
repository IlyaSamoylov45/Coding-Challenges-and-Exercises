// A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
//
// Every adjacent pair of words differs by a single letter.
// Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
// sk == endWord
// Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation sequences from beginWord to endWord, or an empty list if no such sequence exists. Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].
//
//
//
// Example 1:
//
// Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
// Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
// Explanation: There are 2 shortest transformation sequences:
// "hit" -> "hot" -> "dot" -> "dog" -> "cog"
// "hit" -> "hot" -> "lot" -> "log" -> "cog"
// Example 2:
//
// Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
// Output: []
// Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
//
//
// Constraints:
//
// 1 <= beginWord.length <= 5
// endWord.length == beginWord.length
// 1 <= wordList.length <= 1000
// wordList[i].length == beginWord.length
// beginWord, endWord, and wordList[i] consist of lowercase English letters.
// beginWord != endWord
// All the words in wordList are unique.






class Solution {
    Map<String, List<String>> adjList = new HashMap<String, List<String>>();
    List<List<String>> shortestList = new ArrayList<>();
    List<String> currPath = new ArrayList<String>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<String> current = new ArrayList<>();
        buildDAG(beginWord, endWord, wordList);

        currPath.add(beginWord);
        createShortestList(beginWord, endWord, wordList);
        return shortestList;

    }

    private void createShortestList(String beginWord, String endWord, List<String> current){
        if(beginWord.equals(endWord)){
            shortestList.add(new ArrayList<>(currPath));
        }
        if(!adjList.containsKey(beginWord)){
            return;
        }

         for (int i = 0; i < adjList.get(beginWord).size(); i++) {
            currPath.add(adjList.get(beginWord).get(i));
            createShortestList(adjList.get(beginWord).get(i), endWord, currPath);
            currPath.remove(currPath.size() - 1);
        }

    }

    private void buildDAG(String beginWord, String endWord, List<String> wordList){
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();

        set.remove(beginWord);
        queue.offer(beginWord);

        while(!queue.isEmpty() && !set.isEmpty()){
            Set<String> seen = new HashSet<>();
            int size = queue.size();
            while(size-- > 0){
                String currentWord = queue.remove();
                for(String neighbor : findNeighbors(currentWord, set)){
                    List<String> adj = adjList.getOrDefault(currentWord, new ArrayList<>());
                    adj.add(neighbor);
                    adjList.put(currentWord, adj);
                    if(seen.add(neighbor)){
                        queue.add(neighbor);
                    }
                }
            }

            set.removeAll(seen);
        }

    }

    private List<String> findNeighbors(String word, Set<String> wordList) {
        List<String> neighbors = new ArrayList<String>();

        char charList[] = word.toCharArray();

        for (int i = 0; i < word.length(); i++) {
            char oldChar = charList[i];

            for (char c = 'a'; c <= 'z'; c++) {
                charList[i] = c;
                String newWord = String.valueOf(charList);
                if (c != oldChar && wordList.contains(newWord)) {
                    neighbors.add(newWord);
                }
            }
            charList[i] = oldChar;
        }
        return neighbors;
    }
}
// Time complexity: O(NK^2 + α)O(NK^2+α).
//    Here N is the number of words in wordList, K is the maximum length of a word, αα is the number of possible paths from beginWord to endWord in the directed graph we have.
//    Copying the wordList into the set will take O(N).
// Space complexity: O(NK).
//    Here N is the Number of words in wordList, K is the Maximum length of a word.
