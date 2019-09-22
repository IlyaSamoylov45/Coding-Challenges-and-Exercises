/*
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", str = "dog dog dog dog"
Output: false
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.
*/

class Solution {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> vals = new HashMap<>();
        HashMap<String, Character> vals2 = new HashMap<>();
        String[] strArr = str.split(" ");
        if(strArr.length != pattern.length()){
            return false;
        }
        for(int i = 0; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            if(vals.containsKey(c) && !vals.get(c).equals(strArr[i])){
                return false;
            }
            else if(vals2.containsKey(strArr[i]) && vals2.get(strArr[i]) != c){
                return false;
            }else{
                vals.put(c, strArr[i]);
                vals2.put(strArr[i], c);
            }

        }
        return true;
    }
}


//Using Set :

class Solution {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> vals = new HashMap<>();
        Set<String> vals2 = new HashSet<>();
        String[] strArr = str.split(" ");
        if(strArr.length != pattern.length()){
            return false;
        }
        for(int i = 0; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            if(!vals.containsKey(c)){
                if(vals2.contains(strArr[i])){
                    return false;
                }
                vals2.add(strArr[i]);
                vals.put(c, strArr[i]);
            }else if (!vals.get(c).equals(strArr[i])){
                return false;
            }

        }
        return true;
    }
}
