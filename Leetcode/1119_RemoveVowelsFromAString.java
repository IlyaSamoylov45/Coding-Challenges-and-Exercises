/**
Given a string S, remove the vowels 'a', 'e', 'i', 'o', and 'u' from it, and return the new string.



Example 1:

Input: "leetcodeisacommunityforcoders"
Output: "ltcdscmmntyfrcdrs"
Example 2:

Input: "aeiou"
Output: ""


Note:

S consists of lowercase English letters only.
1 <= S.length <= 1000
**/

class Solution {
    public Set<Character> initializeSet(){
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        return set;
    }

    public String removeVowels(String S) {
        StringBuilder sb = new StringBuilder();
        Set<Character> set = initializeSet();
        for(Character c : S.toCharArray()){
            if(!set.contains(c)){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
