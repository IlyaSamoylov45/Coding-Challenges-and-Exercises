// Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.
//
// Examples:
//
// s = "leetcode"
// return 0.
//
// s = "loveleetcode"
// return 2.
//
//
// Note: You may assume the string contains only lowercase English letters.




class Solution {
    public int firstUniqChar(String s) {
        int[] chars = new int[26];
        for(Character c : s.toCharArray()){
            chars[c - 'a']++;
        }
        for(int i = 0; i < s.length(); i++){
            if(chars[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}
// Time : O(N)
// Space : O(1)
