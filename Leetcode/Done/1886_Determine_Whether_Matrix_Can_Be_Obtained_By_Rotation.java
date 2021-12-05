// Given two n x n binary matrices mat and target, return true if it is possible to make mat equal to target by rotating mat in 90-degree increments, or false otherwise.
//
//
//
// Example 1:
//
//
// Input: mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
// Output: true
// Explanation: We can rotate mat 90 degrees clockwise to make mat equal target.
// Example 2:
//
//
// Input: mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
// Output: false
// Explanation: It is impossible to make mat equal to target by rotating mat.
// Example 3:
//
//
// Input: mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
// Output: true
// Explanation: We can rotate mat 90 degrees clockwise two times to make mat equal target.
//
//
// Constraints:
//
// n == mat.length == target.length
// n == mat[i].length == target[i].length
// 1 <= n <= 10
// mat[i][j] and target[i][j] are either 0 or 1.





class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        for(int i = 0; i <= 4; i++){
            if(check(mat, target)){
                return true;
            }
            transpose(mat);
            reverse(mat);
        }
        return false;
    }

    private boolean check(int[][] mat, int[][] target){
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[i].length; j++){
                if(mat[i][j] != target[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    private void transpose(int[][] mat){
        for(int i = 0; i < mat.length; i++){
            for(int j = i; j < mat[i].length; j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }

    private void reverse(int[][] mat){
        for(int i = 0; i < mat.length / 2; i++){
            for(int j = 0; j < mat[i].length; j++){
                int temp = mat[j][i];
                mat[j][i] = mat[j][mat[0].length - i - 1];
                mat[j][mat[0].length - i - 1] = temp;
            }
        }
    }
}
// Time : O(N)
// Space : O(1)






class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int len = mat.length;
        int[] x1 = new int[len], y1 = new int[len], x2 = new int[len], y2 = new int[len];
        for (int i = 0; i < len; i++){
            for (int j = 0; j < len; j++) {
                x1[i] += mat[i][j];
                y1[j] += mat[i][j];
                x2[i] += target[i][j];
                y2[j] += target[i][j];
            }
        }
        int[] rev_x1 = reverse(x1);
        int[] rev_y1 = reverse(y1);

        return (Arrays.equals(x1, x2) && Arrays.equals(y1,y2)) || (Arrays.equals(rev_x1, y2) && Arrays.equals(y1, x2))
        || (Arrays.equals(rev_x1, x2) && Arrays.equals(rev_y1, y2)) || (Arrays.equals(x1, y2) && Arrays.equals(rev_y1, x2));
    }

    private int[] reverse(int[] num){
        int len = num.length;
        int[] num2 = new int[len];
        for(int i = 0; i < len; i++){
            num2[i] = num[len - i - 1];
        }
        return num2;
    }
}
// Time : O(N)
// Space : O(1)
