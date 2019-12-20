/**
Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.



Example 1:

Input: "ab-cd"
Output: "dc-ba"
Example 2:

Input: "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
Example 3:

Input: "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"


Note:

S.length <= 100
33 <= S[i].ASCIIcode <= 122
S doesn't contain \ or "
**/

class Solution {
    public String reverseOnlyLetters(String S) {
        char[] vals = S.toCharArray();
        int start = 0;
        int end = vals.length - 1;
        while(start < end){
            if( ( vals[start] < 'a' || vals[start] > 'z' ) && ( vals[start] < 'A' || vals[start] > 'Z' ) ){
                start++;
            }else if( ( vals[end] < 'a' || vals[end] > 'z' ) && ( vals[end] < 'A' || vals[end] > 'Z' ) ){
                end--;
            }else{
                char temp = vals[start];
                vals[start] = vals[end];
                vals[end] = temp;
                start++;
                end--;
            }
        }
        return new String(vals);
    }
}
