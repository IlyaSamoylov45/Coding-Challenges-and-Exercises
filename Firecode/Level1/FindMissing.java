/*
Given an Array containing 9 numbers ranging from 1 to 10, write a method to find the missing number.
Assume you have 9 numbers between 1 to 10 and only one number is missing.

findMissingNumber({1,2,4,5,6,7,8,9,10}) --> 3
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static int findMissingNumber(int[] arr) {
    int sum = 0;
    for(int i = 0; i < arr.length; i++){
        sum += arr[i];
    }
    return 55 - sum;
}
