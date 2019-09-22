/*
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:

Input: "hello"
Output: "holle"
Example 2:

Input: "leetcode"
Output: "leotcede"
Note:
The vowels does not include the letter "y".
*/

class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        initialize(vowels);
        char[] c = s.toCharArray();
        int i = 0;
        int j = c.length - 1;
        while(i < j){
            if(!vowels.contains(c[i])){
                i++;
            }else if(!vowels.contains(c[j])){
                j--;
            }else{
                swap(c, i, j);
                i++;
                j--;
            }
        }
        return new String(c);
    }
    public void initialize(Set<Character> vowels){
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
    }
    public void swap(char[] c, int i, int j){
        char curr = c[i];
        c[i] = c[j];
        c[j] = curr;
    }
}
