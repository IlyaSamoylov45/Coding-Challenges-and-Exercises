// Given an array of integers, determine if it is possible to split
// the array into two parts such that the sum of all elements in each part is the same.
//
// Examples:
//
// splitArray({1,2,3,4}) ==> true
// splitArray({1,2,4}) ==> false




// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static boolean splitArray(int[] arr) {
    if(arr.length == 0){
        return false;
    }
    int sum = 0;
    for(int x : arr){
        sum += x;
    }
    if(sum%2 != 0){
        return false;
    }
    return groupSum(arr, sum, 0, 0);
}

public static boolean groupSum(int[] arr, int sum, int current, int index){
    if(index >= arr.length){
        if(sum == current){
            return true;
        }
        return false;
    }
    return groupSum(arr, sum - arr[index], current + arr[index], index + 1) || groupSum(arr, sum, current, index + 1) ;
}
// Time : O(2^n)
// Space : O(2^n)
