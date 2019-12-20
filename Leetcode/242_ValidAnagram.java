/**
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
**/

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null){
            return false;
        }
        if(s.length() != t.length()){
            return false;
        }
        int[] vals = new int[26];
        for(int i = 0; i < s.length(); i++){
            vals[s.charAt(i) - 'a']++;
            vals[t.charAt(i) - 'a']--;
        }
        for(Integer i : vals){
            if(i != 0){
                return false;
            }
        }
        return true;

    }
}
