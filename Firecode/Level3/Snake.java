/*
Let's have some fun with 2D Matrices! Write a method findSpiral to traverse a 2D matrix of ints in a clockwise spiral order and append the elements to an output ArrayList if Integers.



Example:

Input Matrix :

    {1, 2, 3}

    {4, 5, 6}

    {7, 8, 9}

Output ArrayList:[1, 2, 3, 6, 9, 8, 7, 4, 5]
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static ArrayList<Integer> findSpiral(int[][] arr) {
    int left = 0;
    int right = arr[0].length - 1;
    int top = 0;
    int bottom = arr.length - 1;
    ArrayList<Integer> vals = new ArrayList<>();
    while(left <= right && top <= bottom){
        for(int i = left; i <= right; i++){
            vals.add(arr[top][i]);
        }
        top++;
        for(int i = top; i <= bottom; i++){
            vals.add(arr[i][right]);
        }
        right--;
        if(top <= bottom){
            for(int i = right; i >= left; i--){
                vals.add(arr[bottom][i]);
            }
        }
        bottom--;
        if(left <= right){
            for(int i = bottom; i >= top; i--){
                vals.add(arr[i][left]);
            }
        }
        left++;
    }
    return vals;
}
