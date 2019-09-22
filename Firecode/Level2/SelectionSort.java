/*
Selection sort offers improved performance over bubble sort, especially for arrays with a large number of elements. Where bubble sort accumulated the largest elements towards the end of the array, selection sort accumulates the smallest elements at the beginning of the array.

Write a method that uses the selection sort algorithm to sort an input array of integers. See the hints and click the red colored links for additonal details on the algorithm.

Examples:

selectionSortArray({1,5,2}) -> {1,2,5}

selectionSortArray({11}) -> {11}

selectionSortArray({}) -> {}
    {} -> [Empty] Array
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static int[] selectionSortArray(int[] arr){
    for(int i = 0; i < arr.length; i++){
        int min = i;
        for(int j = i+1; j < arr.length; j++){
            if(arr[j] < arr[min]){
                min = j;
            }
        }
        swap(arr, min, i);
    }
    return arr;
}

public static void swap(int[] arr, int i, int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}
