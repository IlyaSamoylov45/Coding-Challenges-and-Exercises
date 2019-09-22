/*

Compress a sorted String by replacing instances of repeated characters with the character followed by the count of the character.


compressString("aaabbbbbcccc") --> a3b5c4
compressString("aabbbbccc") --> a2b4c3
compressString("abc") --> abc


Note: This kind of compression will only be effective when the count of consecutive identical characters is greater than 1.
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static String compressString(String text) {
    StringBuilder sb = new StringBuilder();
    int count = 0;
    for(int i = 0; i < text.length(); i++){
        count++;
        if (i + 1 >= text.length() || text.charAt(i) != text.charAt(i + 1)) {
            sb.append(text.charAt(i));
            if (count > 1) {
                sb.append(count);
            }
            count = 0;
        }
    }
    return sb.toString();
}
