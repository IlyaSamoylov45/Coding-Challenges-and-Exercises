// Given two strings s and t, determine if they are isomorphic.
//
// Two strings s and t are isomorphic if the characters in s can be replaced to get t.
//
// All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
//
//
//
// Example 1:
//
// Input: s = "egg", t = "add"
// Output: true
// Example 2:
//
// Input: s = "foo", t = "bar"
// Output: false
// Example 3:
//
// Input: s = "paper", t = "title"
// Output: true
//
//
// Constraints:
//
// 1 <= s.length <= 5 * 104
// t.length == s.length
// s and t consist of any valid ascii character.







class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] values = new int[512];
        for(int i = 0; i < s.length(); i++){
            if(values[s.charAt(i)] == 0 && values[t.charAt(i) + 256] == 0){
                values[s.charAt(i)] = t.charAt(i);
                values[t.charAt(i) + 256] = s.charAt(i);
            }
            if((char)values[s.charAt(i)] != t.charAt(i) || (char)values[t.charAt(i) + 256] != s.charAt(i)){
                return false;
            }

        }
        return true;

    }
}
// Time : O(N)
// Space : O(1)








class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] values = new int[512];
        for(int i = 0; i < s.length(); i++){

            if(values[s.charAt(i)] != values[t.charAt(i) + 256]){
                return false;
            }
            values[s.charAt(i)] = i + 1;
            values[t.charAt(i) + 256] = i + 1;
        }

        return true;

    }
}
// Time : O(N)
// Space : O(1)
