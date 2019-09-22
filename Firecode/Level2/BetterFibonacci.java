/*
The Fibonacci Sequence is the series of numbers: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ... The next number is found by adding up the two numbers before it.

Your goal is to write an optimal method - betterFibonacci that returns the nth Fibonacci number in the sequence. n is 0 indexed, which means that in the sequence 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ..., n == 0 should return 0 and n == 3 should return 2. Your method should exhibit a runtime complexity of O(n) and use constant O(1) space. With this implementation, your method should be able to compute larger sequences where n > 40.

Examples:
fib(0) ==> 0
fib(1) ==> 1
fib(3) ==> 2
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static int betterFibonacci(int n) {
    int first = 0;
    int second = 1;
    while(n > 0){
        int temp = first + second;
        first = second;
        second = temp;

        n--;
    }
    return first;
}
