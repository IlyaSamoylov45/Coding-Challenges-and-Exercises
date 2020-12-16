// Write a function that takes a string as input and reverse only the vowels of a string.
//
// Example 1:
//
// Input: "hello"
// Output: "holle"
// Example 2:
//
// Input: "leetcode"
// Output: "leotcede"
// Note:
// The vowels does not include the letter "y".



class Solution {
    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        char[] x = s.toCharArray();
        int left = 0;
        int right = x.length - 1;
        while(left < right){
            if(vowels.contains(""+x[left]) && vowels.contains(""+x[right])){
                char c = x[left];
                x[left] = x[right];
                x[right] = c;
                left++;
                right--;
            }
            while(left < right && !vowels.contains(""+x[left])){
                left++;
            }
            while(left < right && !vowels.contains(""+x[right])){
               right--;
            }
        }
        return new String(x);
    }
}
// Time : O(N)
// Space : O(N)
