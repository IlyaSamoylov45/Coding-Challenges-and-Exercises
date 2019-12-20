/**
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
**/

class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.isEmpty()){
            return true;
        }
        char[] vals = s.toLowerCase().toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while(i <= j){
            if(!Character.isLetterOrDigit(vals[j])){
                j--;
            }
            else if(!Character.isLetterOrDigit(vals[i])){
                i++;
            }
            else{
                if(vals[i] != vals[j]){
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
}
