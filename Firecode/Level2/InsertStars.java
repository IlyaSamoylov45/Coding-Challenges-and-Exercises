/*
Given a string, recursively compute a new string where the identical adjacent characters in the original string are separated by a "*".

Examples:
insertPairStar("cac") ==> "cac"

insertPairStar("cc") ==> "c*c"
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static String insertPairStar(String s) {
    if(s == null || s.length() <= 1){
        return s;
    }
    return s.charAt(0) + (s.charAt(0) == s.charAt(1) ? "*" : "") + insertPairStar(s.substring(1));
}
