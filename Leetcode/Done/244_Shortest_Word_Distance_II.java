// Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list. Your method will be called repeatedly many times with different parameters.
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



class WordDistance {
    Map<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            List<Integer> vals = map.getOrDefault(words[i], new ArrayList<>());
            vals.add(i);
            map.put(words[i], vals);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> lst1 = map.get(word1);
        List<Integer> lst2 = map.get(word2);
        int min = Integer.MAX_VALUE;
        int l1 = 0;
        int l2 = 0;
        while (l1 < lst1.size() && l2 < lst2.size()) {
            min = Math.min(min, Math.abs(lst1.get(l1) - lst2.get(l2)));
            if (lst1.get(l1) < lst2.get(l2)) {
                l1++;
            } else {
                l2++;
            }
        }
        return min;
    }
}
// Time : O(K + L)
// Space : O(N)
