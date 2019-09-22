/*
Write a method to replace all spaces in a string with a given replacement string.

replace("This is a test","/") --> "This/is/a/test"

Note: Avoid using the in-built String.replaceAll() method.
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static String replace(String a, String b) {
    StringBuilder sb = new StringBuilder();
    String[] vals = a.split(" ");
    for(int i = 0; i < vals.length - 1; i++){
        sb.append(vals[i]);
        sb.append(b);
    }
    sb.append(vals[vals.length-1]);
    return sb.toString();
}
