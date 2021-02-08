// Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
//
// Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
//
//
//
// Example 1:
//
// Input: s = "abccccdd"
// Output: 7
// Explanation:
// One longest palindrome that can be built is "dccaccd", whose length is 7.
// Example 2:
//
// Input: s = "a"
// Output: 1
// Example 3:
//
// Input: s = "bb"
// Output: 2
//
//
// Constraints:
//
// 1 <= s.length <= 2000
// s consists of lowercase and/or uppercase English letters only.





class Solution {
    public int longestPalindrome(String s) {
        int[] vals = new int[256];
        for(int i = 0; i < s.length(); i++){
            vals[s.charAt(i)]++;
        }
        int count = 0;
        boolean one = false;
        for(int i = 0; i < vals.length; i++){
            if(vals[i] % 2 != 0){
                one = true;
            }
            count += vals[i]/2 * 2;
        }
        return one ? count + 1 : count;
    }
}
// Time : O(N)
// Space : O(1)






class Solution {
    public int longestPalindrome(String s) {
        int[] vals = new int[256];
        for(int i = 0; i < s.length(); i++){
            vals[s.charAt(i)]++;
        }
        int count = 0;
        for(int i = 0; i < vals.length; i++){
            count += vals[i]/2 * 2;
        }
        return count < s.length() ? count + 1 : count;
    }
}
// Time : O(N)
// Space : O(1)
