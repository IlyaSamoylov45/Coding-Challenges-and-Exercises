// Given an input string , reverse the string word by word.
//
// Example:
//
// Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
// Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
// Note:
//
// A word is defined as a sequence of non-space characters.
// The input string does not contain leading or trailing spaces.
// The words are always separated by a single space.
// Follow up: Could you do it in-place without allocating extra space?



class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        reverseWord(s);
    }

    private void reverse(char[] s, int left, int right){
        while(left < right){
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }

    private void reverseWord(char[] s){
        int start = 0;
        int len = s.length;
        while(start < len){
            int end = start;
            while(end < len && s[end] != ' '){
                end++;
            }
            reverse(s, start, end - 1);
            start = end + 1;
        }
    }
}
// Time : O(N)
// Space : O(1)
