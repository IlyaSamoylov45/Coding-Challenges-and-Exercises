// Given an array of integers and a target integer, write a method groupSumWithNum to determine if it is possible to choose a group of integers from the array such that the group sums to the given target. An additional constraint is that the summation must include the integer must_have if it is present in the array.
//
// Examples:
// groupSumWithNum({1,2,3,6,5},5,10) ==> true
//
// groupSumWithNum({1,2,3,6,5},3,7) ==> false




// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static boolean groupSumWithNum(int[] arr, int must_have, int target) {
    return groupSumWithNum(arr, must_have, target, 0, false);
}

private static boolean groupSumWithNum(int[] arr, int must_have, int target, int index, boolean seen){
    if(seen && target == 0){
        return true;
    }
    if(index >= arr.length){
        return false;
    }
    if(arr[index] == must_have){
        return groupSumWithNum(arr, must_have, target - arr[index], index + 1, true);
    }else{
        return groupSumWithNum(arr, must_have, target - arr[index], index + 1, seen) || groupSumWithNum(arr, must_have, target, index + 1, seen);
    }
}
// Time : O(2^n)
// Space : O(2^n)
