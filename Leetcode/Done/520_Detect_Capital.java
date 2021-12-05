// We define the usage of capitals in a word to be right when one of the following cases holds:
//
// All letters in this word are capitals, like "USA".
// All letters in this word are not capitals, like "leetcode".
// Only the first letter in this word is capital, like "Google".
// Given a string word, return true if the usage of capitals in it is right.
//
//
//
// Example 1:
//
// Input: word = "USA"
// Output: true
// Example 2:
//
// Input: word = "FlaG"
// Output: false
//
//
// Constraints:
//
// 1 <= word.length <= 100
// word consists of lowercase and uppercase English letters.





class Solution {
    public boolean detectCapitalUse(String word) {
        int count = 0;
        for(char c : word.toCharArray()){
            count += c >= 'A' && c <= 'Z' ? 1 : 0;
        }
        if(count == 1){
            char c = word.charAt(0);
            return c >= 'A' && c <= 'Z';
        }
        return count == word.length() || count == 0;
    }
}
// Time : O(N)
// Space : O(1)





class Solution {
    public boolean detectCapitalUse(String word) {
        int len = word.length();
        if (len == 1) {
            return true;
        }
        if (Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            for (int i = 2; i < len; i++) {
                if (Character.isLowerCase(word.charAt(i))) {
                    return false;
                }
            }
        } else {
            for (int i = 1; i < len; i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
        }

        return true;
    }
}
// Time : O(N)
// Space : O(1)







class Solution {
    public boolean detectCapitalUse(String word) {
        return word.matches("[A-Z]+|[A-Z]{0,1}[a-z]+");
    }
}
// Time : O(N)
// Space : O(1)





class Solution {
    public boolean detectCapitalUse(String word) {
        return word.matches("[A-Z]*|.[a-z]*");
    }
}
// Time : O(N)
// Space : O(1)
