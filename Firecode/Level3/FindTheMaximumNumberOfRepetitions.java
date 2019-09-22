/*
Given an Array of integers, write a method that will return the integer with the maximum number of repetitions. Your code is expected to run with O(n) time complexity and O(1) space complexity. The elements in the array are between 0 to size(array) - 1 and the array will not be empty.

f({3,1,2,2,3,4,4,4}) --> 4
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static int getMaxRepetition(int[] a) {
    int n = a.length;
    for(int i = 0; i < n; i++){
        a[a[i]%n] += n;
    }
    int count = -1;
    int j = -1;
    for(int i = 0; i < n; i++){
        if(a[i] > count){
            count = a[i];
            j = i;
        }
    }
    return j;
}
