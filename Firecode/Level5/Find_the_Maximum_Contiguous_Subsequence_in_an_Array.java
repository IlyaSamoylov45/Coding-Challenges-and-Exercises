// Given an array of integers consisting of both positive and negative
// numbers, find the contiguous subsequence that has the maximum sum among all subsequences in the array (click the red text to learn more about subsequences). Write a method that takes in
// an array of integers arr and returns an array res containing 3 integers in the following format:
//
// res[0] = max sum
// res[1] = starting index of the subsequence
// res[2] = ending index of the subsequence
//
//
// Examples:
//
// maxContSequence({-1,-2,3,4,5}) ==> {12,2,4}
//
// maxContSequence({1,2,3,-2,5}) ==> {6,0,2}





// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static int[] maxContSequence(int[] arr) {
    if(arr == null || arr.length == 0){
        return new int[]{0, 0, -1};
    }
    int max = arr[0], maxSeen = arr[0];
    int startIndex = 0, endIndex = 0;
    for(int i = 1; i < arr.length; i++){
        if(maxSeen + arr[i] < arr[i]){
            startIndex = i;
            maxSeen = arr[i];
        }else{
            maxSeen += arr[i];
        }
        if(max < maxSeen){
            max = maxSeen;
            endIndex = i;
        }
    }
    if(startIndex > endIndex){
        startIndex = endIndex;
    }
    return new int[]{max, startIndex, endIndex};
}
// Time : O(N)
// Space : O(1)
