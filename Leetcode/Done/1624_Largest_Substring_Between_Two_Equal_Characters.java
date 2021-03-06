// Given a string s, return the length of the longest substring between two equal characters, excluding the two characters. If there is no such substring return -1.
//
// A substring is a contiguous sequence of characters within a string.
//
//
//
// Example 1:
//
// Input: s = "aa"
// Output: 0
// Explanation: The optimal substring here is an empty substring between the two 'a's.
// Example 2:
//
// Input: s = "abca"
// Output: 2
// Explanation: The optimal substring here is "bc".
// Example 3:
//
// Input: s = "cbzxy"
// Output: -1
// Explanation: There are no characters that appear twice in s.
// Example 4:
//
// Input: s = "cabbac"
// Output: 4
// Explanation: The optimal substring here is "abba". Other non-optimal substrings include "bb" and "".
//
//
// Constraints:
//
// 1 <= s.length <= 300
// s contains only lowercase English letters.






class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int largest = -1;
        int[] chars = new int[26];
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int prev = chars[c - 'a'];
            if(prev == 0){
                chars[c - 'a'] = i + 1;
            }else if(i - prev > largest){
                largest = i - prev;
            }
        }
        return largest;
    }
}
// Time : O(N)
// Space : O(1)
