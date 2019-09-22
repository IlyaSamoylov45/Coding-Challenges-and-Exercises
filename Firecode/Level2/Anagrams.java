/*
Write a method isAnagram that checks if two lowercase input Strings are anagrams of each other. An anagram of a String is a String that is formed by simply re-arranging its letters, using each letter exactly once. Your algorithm should run in linear O(n) time and use constant O(1) space.

Examples:

isAnagram("abc","cab") => true
isAnagram("b","b") => true
isAnagram("bd","cb") => false
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static boolean isAnagram(String input1, String input2) {
    int[] vals = new int[256];

    if(input1 == null && input2 == null || input1.length() != input2.length()){
        return false;
    }

    for(int i = 0; i < input1.length(); i++){
        int c1 = input1.charAt(i);
        int c2 = input2.charAt(i);
        vals[c1]++;
        vals[c2]--;
    }

    for(int i = 0; i < vals.length; i++){
        if(vals[i] != 0){
            return false;
        }
    }
    return true;
}
