/*
Write a method that takes in an array of ints and uses the Bubble Sort algorithm to sort the array 'in place' in ascending order. The method should return the same, in-place sorted array.

Note: Bubble sort is one of the most inefficient ways to sort a large array of integers. Nevertheless, it is an interview favorite. Bubble sort has a time complexity of O(n2). However, if the sample size is small, bubble sort provides a simple implementation of a classic sorting algorithm.

Examples:
bubbleSortArray({5,4,3}) -> {3,4,5}
bubbleSortArray({3}) -> {3}
bubbleSortArray({}) -> {}
{} -> [Empty] Array
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static int[] bubbleSortArray(int[] arr){
    for(int i = 0; i < arr.length; i++){
        for(int j = 1; j < arr.length-i; j++){
            if(arr[j] < arr[j - 1]){
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
    }
    return arr;
}
