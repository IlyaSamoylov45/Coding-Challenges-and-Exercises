// Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.
//
//
//
// Example 1:
//
// Input: "ab-cd"
// Output: "dc-ba"
// Example 2:
//
// Input: "a-bC-dEf-ghIj"
// Output: "j-Ih-gfE-dCba"
// Example 3:
//
// Input: "Test1ng-Leet=code-Q!"
// Output: "Qedo1ct-eeLg=ntse-T!"
//
//
// Note:
//
// S.length <= 100
// 33 <= S[i].ASCIIcode <= 122
// S doesn't contain \ or "



class Solution {
    public String reverseOnlyLetters(String S) {
        char[] letters = S.toCharArray();
        int left = 0;
        int right = S.length() - 1;
        while(left < right){
            if(Character.isAlphabetic(letters[left]) && Character.isAlphabetic(letters[right])){
                char c = letters[left];
                letters[left] = letters[right];
                letters[right] = c;
                left++;
                right--;
            }
            while(left < right && !Character.isAlphabetic(letters[left])){
                left++;
            }
            while(left < right && !Character.isAlphabetic(letters[right])){
                right--;
            }
        }
        return new String(letters);
    }
}
// Time : O(N)
// Space : O(N)
