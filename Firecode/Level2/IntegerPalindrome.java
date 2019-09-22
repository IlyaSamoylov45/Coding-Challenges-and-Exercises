/*
Write a method that checks if a given integer is a palindrome - without allocating additional heap space

Examples:
-1 ==> false
0 ==> true
1221 ==> true
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static Boolean isIntPalindrome(int x) {
    int divisor = 1;
    if(x < 0){
        return false;
    }
    while (x / divisor >= 10) {
        divisor *= 10;
    }
    while(x>0){
        int last = x%10;
        if(last != x/divisor){
            return false;
        }

        x = (x % divisor) / 10;
        divisor /= 100;
    }
    return true;

}
