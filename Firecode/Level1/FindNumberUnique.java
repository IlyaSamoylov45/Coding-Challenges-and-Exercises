/*
Write a method that returns a number that appears only once in an array.
Assume the array will surely have a unique value. The array will never be empty.
Examples:

{1,2,3,4,1,2,4,3,5} ==> 5
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static int singleNumber(int[] A) {
    int ret = 0;
    HashMap<Integer, Integer> vals = new HashMap<>();
    for(int i = 0; i < A.length; i++){
        if(!vals.containsKey(A[i])){
            vals.put(A[i], 0);
        }
        vals.put(A[i], vals.get(A[i]) + 1);
    }
    for(int i = 0; i < A.length; i++){
        if(vals.get(A[i]) == 1){
            ret = A[i];
        }
    }
    return ret;



}
