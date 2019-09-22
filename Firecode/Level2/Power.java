/*
Write a method - pow(x,n) that returns the value of x raised to the power of n (xn). n can be negative!

Examples:
pow(2,3) ==> 8.0
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static double pow(double x, int n) {
    if(n == 0){
        return 1;
    }
    int sign = n > 0 ? 1 : -1;
    n *= sign;
    double l = x;
    while(n > 1){
        l *= x;
        n--;
    }
    return sign == 1 ? l : 1/l;
}
