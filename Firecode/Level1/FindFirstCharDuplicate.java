/*
Find the first non-duplicate character in a string. Return null if no unique character is found.

firstNonRepeatedCharacter( "abcdcd" ) --> 'a'
firstNonRepeatedCharacter( "cbcd" ) --> 'b'
firstNonRepeatedCharacter( "cdcd" ) --> null
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static Character firstNonRepeatedCharacter(String str) {
    int[] vals = new int[26];
    for(int i = 0; i < str.length(); i++){
        char c = str.charAt(i);
        vals[c-'a']++;
    }

    for(int i = 0; i < str.length(); i++){
        char c = str.charAt(i);
        if(vals[c-'a'] == 1){
            return c;
        }
    }

    return null;
}
