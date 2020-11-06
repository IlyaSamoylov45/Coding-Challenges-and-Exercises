// Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string.
//
// If the last word does not exist, return 0.
//
// Note: A word is defined as a maximal substring consisting of non-space characters only.
//
// Example:
//
// Input: "Hello World"
// Output: 5



class Solution {
    public int lengthOfLastWord(String s) {
        int j = s.length() - 1;
        while(j >= 0 && s.charAt(j) == ' '){
            j--;
        }
        int start = j;
        while(j >= 0 && s.charAt(j) != ' '){
            j--;
        }
        return start - j;
    }
}
// Time : O(N)
// Space : O(1);
