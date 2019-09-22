/*
Write a method that searches an Array of integers for a given integer using the
Binary Search Algorithm. If the input integer is found in the array, return true. Otherwise, return false.
You can assume that the given array of integers is already sorted
in ascending order.

Examples:

binarySearch({2,5,7,8,9},9) -> true
binarySearch({2,8,9,12},6) -> false
binarySearch({2},4) -> false
binarySearch({},9) -> false
{} -> [Empty] Array
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static Boolean binarySearch(int[] arr, int n){
    int left = 0;
    int right = arr.length - 1;

    while(left<=right){
        int mid = ((right - left) / 2) + left;
        if(arr[mid] == n){
            return true;
        }
        else if(arr[mid] < n){
            left = mid + 1;
        }else{
            right = mid - 1;
        }
    }

    return false;
}
