/*
Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.

Example 1:

Input: S = "loveleetcode", C = 'e'
Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]


Note:

S string length is in [1, 10000].
C is a single character, and guaranteed to be in string S.
All letters in S and C are lowercase.
*/

class Solution {
    public int[] shortestToChar(String S, char C) {
        int[] vals = new int[S.length()];
        Arrays.fill(vals, Integer.MAX_VALUE);
        int pos = -S.length();
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == C){
                pos = i;
            }
            vals[i] = i - pos;
        }
        pos = Integer.MAX_VALUE;
        for(int i = S.length() - 1; i >= 0; i--){
            if(S.charAt(i) == C){
                pos = i;
            }
            vals[i] = Math.min(vals[i], pos-i);
        }
        return vals;
    }
}
