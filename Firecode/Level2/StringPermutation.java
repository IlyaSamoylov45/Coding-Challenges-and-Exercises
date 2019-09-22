/*
Implement a method that checks if two strings are permutations of each other.


permutation("CAT","ACT") --> true

permutation("hello","aloha") --> false
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static boolean permutation(String str1, String str2) {
    if(str1.length() != str2.length()){
        return false;
    }
    int[] vals = new int[256];
    for(int i = 0; i < str1.length(); i++){
        vals[str1.charAt(i)]++;
        vals[str2.charAt(i)]--;
    }
    for(int i = 0; i < vals.length; i++){
        if(vals[i] != 0){
            return false;
        }
    }
    return true;
}
