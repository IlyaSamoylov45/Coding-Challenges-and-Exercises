// Given an array of strings strs, group the anagrams together. You can return the answer in any order.
//
// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
//
//
//
// Example 1:
//
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
// Example 2:
//
// Input: strs = [""]
// Output: [[""]]
// Example 3:
//
// Input: strs = ["a"]
// Output: [["a"]]
//
//
// Constraints:
//
// 1 <= strs.length <= 104
// 0 <= strs[i].length <= 100
// strs[i] consists of lower-case English letters.



class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List> groups = new HashMap<>();
        for(String word : strs){
            int[] count = new int[26];
            for(Character c : word.toCharArray()){
                count[c-'a']++;
            }
            StringBuilder sb = new StringBuilder("");
            for(Integer x : count){
                sb.append(x);
                sb.append('#');
            }
            List<String> values = groups.getOrDefault(sb.toString(), new ArrayList<>());
            values.add(word);
            groups.put(sb.toString(), values);

        }

        return new ArrayList(groups.values());
    }
}
// Time : O(NK)
// Space : O(NK)
