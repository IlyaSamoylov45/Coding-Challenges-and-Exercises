/*
Write a method to compute the binary representation of a positive integer. The method should return a string with 1s and 0s.

computeBinary(6) ==> "110"
computeBinary(5) ==> "101"

Note: Use the minimum number of binary digits needed for the representation (Truncate unnecessary trailing 0s).
computeBinary(5) ==> "0101" (incorrect)
computeBinary(5) ==> "101" (correct)
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static String computeBinary(int val) {
    StringBuilder sb = new StringBuilder();
    if(val == 0){
        return "0";
    }
    while(val > 0){
        sb.append(val%2);
        val >>= 1;
    }
    return sb.reverse().toString();
}
