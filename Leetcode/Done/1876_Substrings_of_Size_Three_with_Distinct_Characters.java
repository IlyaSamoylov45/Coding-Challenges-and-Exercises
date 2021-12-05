// A string is good if there are no repeated characters.
//
// Given a string s​​​​​, return the number of good substrings of length three in s​​​​​​.
//
// Note that if there are multiple occurrences of the same substring, every occurrence should be counted.
//
// A substring is a contiguous sequence of characters in a string.
//
//
//
// Example 1:
//
// Input: s = "xyzzaz"
// Output: 1
// Explanation: There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz".
// The only good substring of length 3 is "xyz".
// Example 2:
//
// Input: s = "aababcabc"
// Output: 4
// Explanation: There are 7 substrings of size 3: "aab", "aba", "bab", "abc", "bca", "cab", and "abc".
// The good substrings are "abc", "bca", "cab", and "abc".
//
//
// Constraints:
//
// 1 <= s.length <= 100
// s​​​​​​ consists of lowercase English letters.





class Solution {
    public int countGoodSubstrings(String s) {
        int count = 0;
        for(int i = 1; i < s.length() - 1; i++){
            count += s.charAt(i-1) != s.charAt(i)
                && s.charAt(i) != s.charAt(i+1)
                && s.charAt(i - 1) != s.charAt(i+1) ? 1 : 0;
        }
        return count;
    }
}
// Time : O(N)
// Space : O(1)





class Solution {
    public int countGoodSubstrings(String s) {
        int vals[] = new int[26], repeat = 0, res = 0;
        for(int i = 0; i < s.length(); ++i) {
            repeat += vals[s.charAt(i) - 'a']++ == 1 ? 1 : 0;
            repeat -= i >= 3 && vals[s.charAt(i - 3) - 'a']-- == 2 ? 1 : 0;
            res += i >= 2 && repeat == 0 ? 1 : 0;
        }
        return res;
    }
}
// Time : O(N)
// Space : O(1)
