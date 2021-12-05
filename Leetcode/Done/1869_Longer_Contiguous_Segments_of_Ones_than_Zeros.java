// Given a binary string s, return true if the longest contiguous segment of 1s is strictly longer than the longest contiguous segment of 0s in s. Return false otherwise.
//
// For example, in s = "110100010" the longest contiguous segment of 1s has length 2, and the longest contiguous segment of 0s has length 3.
// Note that if there are no 0s, then the longest contiguous segment of 0s is considered to have length 0. The same applies if there are no 1s.
//
//
//
// Example 1:
//
// Input: s = "1101"
// Output: true
// Explanation:
// The longest contiguous segment of 1s has length 2: "1101"
// The longest contiguous segment of 0s has length 1: "1101"
// The segment of 1s is longer, so return true.
// Example 2:
//
// Input: s = "111000"
// Output: false
// Explanation:
// The longest contiguous segment of 1s has length 3: "111000"
// The longest contiguous segment of 0s has length 3: "111000"
// The segment of 1s is not longer, so return false.
// Example 3:
//
// Input: s = "110100010"
// Output: false
// Explanation:
// The longest contiguous segment of 1s has length 2: "110100010"
// The longest contiguous segment of 0s has length 3: "110100010"
// The segment of 1s is not longer, so return false.
//
//
// Constraints:
//
// 1 <= s.length <= 100
// s[i] is either '0' or '1'.





class Solution {
    public boolean checkZeroOnes(String s) {
        int max_ones = 0;
        int max_zeroes = 0;
        int count = 1;
        int len = s.length() - 1;
        for(int i = 1; i <= len; i++, count++){
            if(s.charAt(i) != s.charAt(i - 1)){
                if(s.charAt(i - 1) == '0'){
                    max_zeroes = Math.max(max_zeroes, count);
                }else{
                    max_ones = Math.max(max_ones, count);
                }
                count = 0;
            }
        }

        if(s.charAt(len) == '0'){
            max_zeroes = Math.max(max_zeroes, count);
        }else{
            max_ones = Math.max(max_ones, count);
        }
        count = 0;

        return max_ones > max_zeroes;
    }

}
// Time : O(N)
// Space : O(1)






class Solution {
    public boolean checkZeroOnes(String s) {
        int max_ones = 0;
        int max_zeroes = 0;
        int count_ones = 0;
        int count_zeros = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                count_ones = 0;
                count_zeros++;
                max_zeroes = Math.max(max_zeroes, count_zeros);
            }else{
                count_zeros = 0;
                count_ones++;
                max_ones = Math.max(max_ones, count_ones);
            }

        }

        return max_ones > max_zeroes;
    }
}
// Time : O(N)
// Space : O(1)
