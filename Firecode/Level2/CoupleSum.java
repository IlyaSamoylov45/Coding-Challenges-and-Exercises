/*
Given an array of integers, find two numbers such that they sum up to a specific target.
The method coupleSum should return the indices of the two numbers in the array, where index1 must be less than index2.
Please note that the indices are not zero based, and you can assume that each input has exactly one solution. Target linear runtime and space complexity.

Example:
Input Array : {2, 3, 4, 7}
Target      : 7
Output      : {2, 3}
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static int[] coupleSum(int[] numbers, int target) {
    HashMap<Integer,Integer> vals = new HashMap<>();

    for(int i = 0; i < numbers.length; i++){
        if(vals.containsKey(target - numbers[i])){
            return new int[]{vals.get(target - numbers[i]), i+1};
        }
        vals.put(numbers[i], i + 1);
    }
    return new int[2];
}
