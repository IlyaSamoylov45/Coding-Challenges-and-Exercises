// Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.
//
// You may return the answer in any order.
//
//
//
// Example 1:
//
// Input: ["bella","label","roller"]
// Output: ["e","l","l"]
// Example 2:
//
// Input: ["cool","lock","cook"]
// Output: ["c","o"]
//
//
// Note:
//
// 1 <= A.length <= 100
// 1 <= A[i].length <= 100
// A[i][j] is a lowercase letter




class Solution {
    public List<String> commonChars(String[] A) {
        int[] vals = new int[26];
        Arrays.fill(vals, Integer.MAX_VALUE);
        for(String word : A){
            int[] curr = new int[26];
            for(Character c : word.toCharArray()){
                curr[c - 'a']++;
            }
            for(int i = 0; i < vals.length; i++){
                vals[i] = Math.min(vals[i], curr[i]);
            }
        }
        List<String> letters = new ArrayList<>();
        for(char c = 'a'; c <= 'z'; c++){
            while(vals[c-'a']-- > 0){
                letters.add(""+c);
            }
        }
        return letters;
    }
}
// Time: O(N*M)
// Space : O(1)
