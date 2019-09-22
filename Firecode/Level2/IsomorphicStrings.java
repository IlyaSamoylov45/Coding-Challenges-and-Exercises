/*
Given two strings - input1 and input2, determine if they are isomorphic.
Two strings are isomorphic if the letters in one string can be remapped to get the second string. Remapping a letter means replacing all occurrences of it with another letter. The ordering of the letters remains unchanged. You can also think of isomorphism as it is used in chemistry - i.e. having the same form or overall shape. Target linear time and space complexity with your solution.

Examples:
Input 1 : css
Input 2 : dll
Output  : true

Input 1 : css
Input 2 : dle
Output  : false

Input 1 : abcabc
Input 2 : xyzxyz
Output  : true

Input 1 : abcabc
Input 2 : xbexyz
Output  : false
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static boolean isIsomorphic(String input1, String input2) {
    if(input1.length() != input2.length()){
        return false;
    }
    HashMap<Character, Character> vals = new HashMap<>();
    HashMap<Character, Character> vals2 = new HashMap<>();
    for(int i = 0; i < input1.length(); i++){
        char c1 = input1.charAt(i);
        char c2 = input2.charAt(i);
        if(vals.containsKey(c1)){
            if(vals.get(c1) != c2){
                return false;
            }
        }
        if(vals2.containsKey(c2)){
            if(vals2.get(c2) != c1){
                return false;
            }
        }
        vals.put(c1, c2);
        vals2.put(c2, c1);
    }
    return true;

}
