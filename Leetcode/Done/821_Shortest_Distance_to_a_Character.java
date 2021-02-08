// Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.
//
// Example 1:
//
// Input: S = "loveleetcode", C = 'e'
// Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
//
//
// Note:
//
// S string length is in [1, 10000].
// C is a single character, and guaranteed to be in string S.
// All letters in S and C are lowercase.





class Solution {
    public int[] shortestToChar(String S, char C) {
        int[] values = new int[S.length()];
        int current = S.length();
        Arrays.fill(values, S.length());
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == C){
                current = 0;
            }else{
                current++;
            }
            values[i] = Math.min(current, values[i]);
        }
        for(int i = S.length() - 1; i >= 0; i--){
            if(S.charAt(i) == C){
                current = 0;
            }else{
                current++;
            }
            values[i] = Math.min(current, values[i]);
        }
        return values;
    }
}
// Time : O(N)
// Space : O(N)






class Solution {
    public int[] shortestToChar(String S, char C) {
        int n = S.length();
        int[] values = new int[n];
        int pos = -n;
        for(int i = 0; i < n; i++){
            if(S.charAt(i) == C){
                pos = i;
            }
            values[i] = i - pos;
        }
        for(int i = pos - 1; i >= 0; i--){
            if(S.charAt(i) == C){
                pos = i;
            }
            values[i] = Math.min(pos - i, values[i]);
        }
        return values;
    }
}
// Time : O(N)
// Space : O(N)
