/*
Implement a method that reverses an integer - without using additional heap space

Examples:
-123 ==> -321
123 ==> 321
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static int reverseInt(int x) {
    int rev = 0;
    int sign = x < 0 ? -1 : 1;
    x *= sign;
    while(x > 0){
        rev = rev*10 + x%10;
        x /= 10;
    }
    return rev * sign;
}
