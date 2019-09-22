/*
Given an array of integers, write a method - maxGain - that returns the maximum gain. Maximum Gain is defined as the maximum difference between 2 elements in a list such that the larger element appears after the smaller element. If no gain is possible, return 0.
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static int maxGain(int arr[]){
    int gain = 0;
    int min = arr[0];
    for(int i = 1; i < arr.length; i++){
        if (arr[i] - min > gain){
            gain = arr[i] - min;
        }
        if (arr[i] < min){
            min = arr[i];
        }
    }
    return gain;
}
