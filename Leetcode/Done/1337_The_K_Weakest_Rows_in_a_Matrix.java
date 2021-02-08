// Given a m * n matrix mat of ones (representing soldiers) and zeros (representing civilians), return the indexes of the k weakest rows in the matrix ordered from the weakest to the strongest.
//
// A row i is weaker than row j, if the number of soldiers in row i is less than the number of soldiers in row j, or they have the same number of soldiers but i is less than j. Soldiers are always stand in the frontier of a row, that is, always ones may appear first and then zeros.
//
//
//
// Example 1:
//
// Input: mat =
// [[1,1,0,0,0],
//  [1,1,1,1,0],
//  [1,0,0,0,0],
//  [1,1,0,0,0],
//  [1,1,1,1,1]],
// k = 3
// Output: [2,0,3]
// Explanation:
// The number of soldiers for each row is:
// row 0 -> 2
// row 1 -> 4
// row 2 -> 1
// row 3 -> 2
// row 4 -> 5
// Rows ordered from the weakest to the strongest are [2,0,3,1,4]
// Example 2:
//
// Input: mat =
// [[1,0,0,0],
//  [1,1,1,1],
//  [1,0,0,0],
//  [1,0,0,0]],
// k = 2
// Output: [0,2]
// Explanation:
// The number of soldiers for each row is:
// row 0 -> 1
// row 1 -> 4
// row 2 -> 1
// row 3 -> 1
// Rows ordered from the weakest to the strongest are [0,2,3,1]
//
//
// Constraints:
//
// m == mat.length
// n == mat[i].length
// 2 <= n, m <= 100
// 1 <= k <= m
// matrix[i][j] is either 0 or 1.







class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) ->  a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);
        for(int i = 0; i < mat.length; i++){
            int soldiers = 0;
            for(int j = 0; j < mat[i].length; j++){
                soldiers += mat[i][j];
            }
            queue.offer(new int[]{soldiers, i});
            if (queue.size() > k){
                queue.remove();
            }
        }
        int[] values = new int[k];
        while(!queue.isEmpty()){
            values[--k] = queue.remove()[1];
        }
        return values;
    }
}
// Time :  M * N + M * log(K)
// Space : O(K)






class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) ->  a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);
        for(int i = 0; i < mat.length; i++){
            queue.offer(new int[]{search(mat[i]), i});
            if (queue.size() > k){
                queue.remove();
            }
        }
        int[] values = new int[k];
        while(!queue.isEmpty()){
            values[--k] = queue.remove()[1];
        }
        return values;
    }

    private int search(int[] row){
        int left = 0;
        int right = row.length;
        while(left < right){
            int mid = left + (right - left)/2;
            if(row[mid] == 1){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}
// Time :  M * Log(N) + M * log(K)
// Space : O(K)
