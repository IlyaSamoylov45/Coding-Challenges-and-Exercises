// Given a string S, return the number of substrings that have only one distinct letter.
//
//
//
// Example 1:
//
// Input: S = "aaaba"
// Output: 8
// Explanation: The substrings with one distinct letter are "aaa", "aa", "a", "b".
// "aaa" occurs 1 time.
// "aa" occurs 2 times.
// "a" occurs 4 times.
// "b" occurs 1 time.
// So the answer is 1 + 2 + 4 + 1 = 8.
// Example 2:
//
// Input: S = "aaaaaaaaaa"
// Output: 55
//
//
// Constraints:
//
// 1 <= S.length <= 1000
// S[i] consists of only lowercase English letters.





class Solution {
    public int countLetters(String S) {
        int count = 0;
        char prev = 'A';
        for(int i = 0, ops = 0; i < S.length(); i++){
            char curr = S.charAt(i);
            if(prev == curr){
                ops++;
            }else{
                prev = curr;
                ops = 1;
            }
            count += ops;
        }
        return count;
    }
}
// Time : O(N)
// Space : O(1)
