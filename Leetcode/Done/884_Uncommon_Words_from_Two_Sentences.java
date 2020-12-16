// We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)
//
// A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
//
// Return a list of all uncommon words.
//
// You may return the list in any order.
//
//
//
// Example 1:
//
// Input: A = "this apple is sweet", B = "this apple is sour"
// Output: ["sweet","sour"]
// Example 2:
//
// Input: A = "apple apple", B = "banana"
// Output: ["banana"]
//
//
// Note:
//
// 0 <= A.length <= 200
// 0 <= B.length <= 200
// A and B both contain only spaces and lowercase letters.



class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> count = new HashMap<>();
        for (String word: (A + " " + B).split(" ")){
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        List<String> uncommon = new ArrayList<>();
        for(String word : count.keySet()){
            if(count.get(word) == 1){
                uncommon.add(word);
            }
        }
        return uncommon.toArray(new String[uncommon.size()]);
    }
}
// Time : O(M + N)
// Space : O(M + N)
