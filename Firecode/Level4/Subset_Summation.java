// Given an array of integers and a target number, determine if it is possible to choose a group of integers from the array, such that the numbers in the group sum to the given target.
//
// Examples:
// groupSum({1,2,3,6,5},10) ==> true
//
// groupSum({1,2,3,6,5},18) ==> false
//



public static boolean groupSum(int[] arr, int target) {
    return groupSumSupport(arr, target, 0);
}

private static boolean groupSumSupport(int[] arr, int target, int index){
    if(arr.length <= index){
        return target == 0;
    }
    for(int i = index; i < arr.length; i++){
        return groupSumSupport(arr, target - arr[i], index + 1) || groupSumSupport(arr, target, index + 1);
    }
    return false;
}
// Time : O(2^N)
// Space : O(2^N)
