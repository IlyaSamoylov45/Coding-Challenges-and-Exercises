// Given a list of phrases, generate a list of Before and After puzzles.
//
// A phrase is a string that consists of lowercase English letters and spaces only. No space appears in the start or the end of a phrase. There are no consecutive spaces in a phrase.
//
// Before and After puzzles are phrases that are formed by merging two phrases where the last word of the first phrase is the same as the first word of the second phrase.
//
// Return the Before and After puzzles that can be formed by every two phrases phrases[i] and phrases[j] where i != j. Note that the order of matching two phrases matters, we want to consider both orders.
//
// You should return a list of distinct strings sorted lexicographically.
//
//
//
// Example 1:
//
// Input: phrases = ["writing code","code rocks"]
// Output: ["writing code rocks"]
// Example 2:
//
// Input: phrases = ["mission statement",
//                   "a quick bite to eat",
//                   "a chip off the old block",
//                   "chocolate bar",
//                   "mission impossible",
//                   "a man on a mission",
//                   "block party",
//                   "eat my words",
//                   "bar of soap"]
// Output: ["a chip off the old block party",
//          "a man on a mission impossible",
//          "a man on a mission statement",
//          "a quick bite to eat my words",
//          "chocolate bar of soap"]
// Example 3:
//
// Input: phrases = ["a","b","a"]
// Output: ["a"]
//
//
// Constraints:
//
// 1 <= phrases.length <= 100
// 1 <= phrases[i].length <= 100








class Solution {
    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        Map<String, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < phrases.length; ++i) {
            String word = head(phrases[i]);
            List<Integer> lst = map.getOrDefault(word, new ArrayList<>());
            lst.add(i);
            map.put(word, lst);
        }
        TreeSet<String> ans = new TreeSet<>();
        for(int i = 0; i < phrases.length; i++){
            String tail = tail(phrases[i]);
            if(map.containsKey(tail)){
                for (Integer j : map.get(tail)) {
                    if(j != i){
                        ans.add(phrases[i] + phrases[j].substring(tail.length()));
                    }
                }
            }

        }
        return new ArrayList<>(ans);
    }

    private String head(String phrase) {
        String[] array = phrase.split(" ");
        return array[0];
    }

    private String tail(String phrase) {
        String[] array = phrase.split(" ");
        return array[array.length - 1];
    }

}
// Time : O(N)
// Space : O(N)
