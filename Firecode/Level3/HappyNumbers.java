/*
Write a method to determine whether a postive number is Happy.
A number is Happy (Yes, it is a thing!) if it follows a sequence that ends in 1 after following the steps given below :
Beginning with the number itself, replace it by the sum of the squares of its digits until either the number becomes 1 or loops endlessly in a cycle that does not include 1.

For instance, 19 is a happy number. Sequence:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

Example:

Input : 19
Output: true
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static boolean isHappyNumber(int n) {
    if( n <= 0 ) {
        return false;
    }
    Set<Integer> inLoop = new HashSet<Integer>();

    while(true){
        int sum = 0;
        if(n == 1){
            break;
        }
        if(inLoop.contains(n)){
            return false;
        }
        inLoop.add(n);
        while(n!=0){
            sum+=(n%10)*(n%10);
            n=n/10;
        }
        n = sum;
    }
    return true;
}
