/*
The idea behind the classic Mergesort algorithm is to divide an array in half, sort each half, and then use
a merge() method to merge the two halves into a single sorted array.


Implement the merge() method that takes in
two sorted arrays and returns a third sorted array that contains elements of both the input arrays.

You can assume
that the input arrays will always be sorted in ascending order and can have different sizes.


Examples:

merge({2,5,7,8,9},{9}) -> {2,5,7,8,9,9}
merge()({7,8},{1,2}) -> {1,2,7,8}
merge()({2},{}) -> {2}
   {} -> [Empty] Array
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static int[] merge(int[] arrLeft, int[] arrRight){
    int[] vals = new int[arrLeft.length + arrRight.length];
    int i = 0;
    int j = 0;
    while(i < arrLeft.length && j < arrRight.length){
        if(arrLeft[i] < arrRight[j]){
            vals[i+j] = arrLeft[i];
            i++;
        }else{
            vals[i+j] = arrRight[j];
            j++;
        }
    }
    while(i < arrLeft.length){
        vals[i+j] = arrLeft[i];
        i++;
    }
    while(j < arrRight.length){
        vals[i+j] = arrRight[j];
        j++;
    }
    return vals;

}
