// Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
//
//
//
// Example 1:
//
// Input: "Hello"
// Output: "hello"
// Example 2:
//
// Input: "here"
// Output: "here"
// Example 3:
//
// Input: "LOVELY"
// Output: "lovely"




class Solution {
    public String toLowerCase(String str) {
        char[] vals = str.toCharArray();
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c >= 'A' && c <= 'Z'){
                c = (char)(c - 'A' + 'a');
            }
            vals[i] = c;
        }
        return new String(vals);
    }
}
// Time : O(N)
// Space : O(N)
