// Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
//
// A shift on s consists of moving the leftmost character of s to the rightmost position.
//
// For example, if s = "abcde", then it will be "bcdea" after one shift.
//
//
// Example 1:
//
// Input: s = "abcde", goal = "cdeab"
// Output: true
// Example 2:
//
// Input: s = "abcde", goal = "abced"
// Output: false
//
//
// Constraints:
//
// 1 <= s.length, goal.length <= 100
// s and goal consist of lowercase English letters.






class Solution {
    public boolean rotateString(String A, String B) {
        if(B.length() != A.length()){
            return false;
        }
        String X = B + B;
        return X.contains(A);
    }
}
// Time : O(N^2)
// Space : O(N)






class Solution {
    public boolean rotateString(String A, String B) {
        if(B.length() != A.length()){
            return false;
        }
        char c = A.charAt(0);

        int i = 0;
        while(i < B.length()){
             while(i < B.length() && B.charAt(i) != c) {
                i++;
            }
            for(int j = 0; j < A.length(); j++){
                if(A.charAt(j) != B.charAt((j + i) % B.length())){
                    break;
                }

                if(j == B.length() - 1) {
                    return true;
                }
            }
            i++;

        }
        return false;
    }
}
// Time : O(N^2)
// Space : O(1)
