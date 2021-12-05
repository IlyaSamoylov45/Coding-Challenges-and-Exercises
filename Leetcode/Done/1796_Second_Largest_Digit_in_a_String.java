// Given an alphanumeric string s, return the second largest numerical digit that appears in s, or -1 if it does not exist.
//
// An alphanumeric string is a string consisting of lowercase English letters and digits.
//
//
//
// Example 1:
//
// Input: s = "dfa12321afd"
// Output: 2
// Explanation: The digits that appear in s are [1, 2, 3]. The second largest digit is 2.
// Example 2:
//
// Input: s = "abc1111"
// Output: -1
// Explanation: The digits that appear in s are [1]. There is no second largest digit.
//
//
// Constraints:
//
// 1 <= s.length <= 500
// s consists of only lowercase English letters and/or digits.






class Solution {
    public int secondHighest(String s) {
        int first = -1;
        int second = -1;
        for(char c : s.toCharArray()){
            if(isDigit(c)){
                int x = c - '0';
                if(first < x){
                    second = first;
                    first = x;
                }else if(second < x && x != first){
                    second = x;
                }
            }
        }
        return second == first ? -1 : second;
    }

    private boolean isDigit(char c){
        return c >= '0' && c <= '9';
    }
}
// Time : O(N)
// Space : O(1)
