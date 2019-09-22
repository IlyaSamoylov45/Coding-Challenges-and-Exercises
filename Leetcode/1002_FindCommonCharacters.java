/*
Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.

You may return the answer in any order.



Example 1:

Input: ["bella","label","roller"]
Output: ["e","l","l"]
Example 2:

Input: ["cool","lock","cook"]
Output: ["c","o"]


Note:

1 <= A.length <= 100
1 <= A[i].length <= 100
A[i][j] is a lowercase letter
*/

class Solution {
    public List<String> commonChars(String[] A) {
        List<String> vals = new LinkedList<>();
        int[] common = new int[26];
        Arrays.fill(common, Integer.MAX_VALUE);
        for(String s : A){
            int[] curr = new int[26];
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                curr[c-'a']++;
            }
            for (int i = 0; i < 26; i++) {
                common[i] = Math.min(curr[i], common[i]);
            }
        }
        for(int i = 0; i < common.length; i++){
            char curr = (char)('a' + i);
            while (common[i]-- > 0) {
                vals.add("" + curr);
            }
        }
        return vals;
    }
}
