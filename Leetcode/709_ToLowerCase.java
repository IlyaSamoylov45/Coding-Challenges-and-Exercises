/*
Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.



Example 1:

Input: "Hello"
Output: "hello"
Example 2:

Input: "here"
Output: "here"
Example 3:

Input: "LOVELY"
Output: "lovely"
*/

class Solution {
    public String toLowerCase(String str) {
        if(str == null || str.isEmpty()){
            return str;
        }
        char[] arr = str.toCharArray();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] >= 'A' && arr[i] <= 'Z'){
                arr[i] = (char)(arr[i] - 'A' + 'a');
            }
        }
        return new String(arr);
    }
}
