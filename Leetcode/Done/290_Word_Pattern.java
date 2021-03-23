// Given a pattern and a string s, find if s follows the same pattern.
//
// Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
//
//
//
// Example 1:
//
// Input: pattern = "abba", s = "dog cat cat dog"
// Output: true
// Example 2:
//
// Input: pattern = "abba", s = "dog cat cat fish"
// Output: false
// Example 3:
//
// Input: pattern = "aaaa", s = "dog cat cat dog"
// Output: false
// Example 4:
//
// Input: pattern = "abba", s = "dog dog dog dog"
// Output: false
//
//
// Constraints:
//
// 1 <= pattern.length <= 300
// pattern contains only lower-case English letters.
// 1 <= s.length <= 3000
// s contains only lower-case English letters and spaces ' '.
// s does not contain any leading or trailing spaces.
// All the words in s are separated by a single space.







class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        int start = 0;
        int i = 0;
        for(;i < pattern.length() && start < s.length(); i++){
            int end = start + 1;
            char c = pattern.charAt(i);
            while(end < s.length() && s.charAt(end) != ' '){
                end++;
            }
            String current = s.substring(start,end);
            if(map.containsKey(c) && !map.get(c).equals(current)){
                return false;
            }else if(!map.containsKey(c) && !set.add(current)){
                return false;
            }
            map.put(c, current);
            start = end + 1;
        }
        return start >= s.length() && i >= pattern.length();
    }
}
// Time : O(N + M)
// Space : O(N + M)








class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map map = new HashMap();
        int start = 0;
        int i = 0;
        for(;i < pattern.length() && start < s.length(); i++){
            int end = start + 1;
            while(end < s.length() && s.charAt(end) != ' '){
                end++;
            }
            char c = pattern.charAt(i);
            String current = s.substring(start,end);
            if(!map.containsKey(c)){
                map.put(c, i);
            }
            if(!map.containsKey(current)){
                map.put(current, i);
            }
            if(!map.get(c).equals(map.get(current))){
                return false;
            }
            start = end + 1;
        }
        return start >= s.length() && i >= pattern.length();
    }
}
// Time : O(N + M)
// Space : O(N + M)








class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map map = new HashMap();
        String[] words = s.split(" ");
        if(pattern.length() != words.length){
            return false;
        }
        for(int i = 0; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            String current = words[i];
            if(!map.containsKey(c)){
                map.put(c, i);
            }
            if(!map.containsKey(current)){
                map.put(current, i);
            }
            if(!map.get(c).equals(map.get(current))){
                return false;
            }
        }
        return true;
    }
}
// Time complexity : O(N) where N represents the number of words in the s or the number of characters in the pattern.
// Space complexity : O(M) where M is the number of unique characters in pattern and words in s
