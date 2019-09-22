/*
Write a method that takes in a String and returns the reversed version of the String.

Examples:
reverseString("abcde") -> "edcba"
reverseString("1") -> "1"
reverseString("") -> ""
reverse("madam") -> "madam"
reverse(null) -> null
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static String reverseString(String str){
    StringBuilder sb = new StringBuilder();
    if(str == null){
        return null;
    }
    for(int i = str.length() - 1; i >= 0; i--){
        sb.append(str.charAt(i));
    }


    return sb.toString();
}
