/*
Write a method - isPowOfTwo to test whether or not a given positive integer is a power of 2. Your method should run in constant O(1) time and use O(1) space.


Examples:

isPowOfTwo(5) ==> false
isPowOfTwo(8) ==> true
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static boolean isPowOfTwo(int num) {
    return (num & (num-1)) == 0;
}
