// Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//
// Note: For the purpose of this problem, we define empty string as valid palindrome.
//
// Example 1:
//
// Input: "A man, a plan, a canal: Panama"
// Output: true
// Example 2:
//
// Input: "race a car"
// Output: false
//
//
// Constraints:
//
// s consists only of printable ASCII characters.



class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0;
        int n = s.length() - 1;
        while(i < n){
            while(i < n && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while(i < n && !Character.isLetterOrDigit(s.charAt(n))){
                n--;
            }
            if(i < n && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(n))){
                return false;
            }
            i++;
            n--;
        }
        return true;
    }
}
// Time : O(N)
// Space : O(1)
