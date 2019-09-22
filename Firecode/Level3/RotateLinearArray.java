/*
Rotate an array to the left by k positions without using extra space.k can be greater than the size of the array.

Example:
rotateLeft({1,2,3,4,5},2) --> {3,4,5,1,2}
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static int[] rotateLeft(int[] arr, int k) {
    int i = 0;
    int n = arr.length;
    int[] vals = new int[n];
    while(i < n){
        vals[i] = arr[(i+k)%n];
        i++;
    }
    return vals;
}
