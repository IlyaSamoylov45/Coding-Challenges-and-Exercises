// Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
//
// For example, given the following triangle
//
// [
//      [2],
//     [3,4],
//    [6,5,7],
//   [4,1,8,3]
// ]
// The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
//
// Note:
//
// Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.



class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i = triangle.size() - 2; i >= 0; i--){
            List<Integer> prev = triangle.get(i + 1);
            List<Integer> curr = triangle.get(i);
            for(int j = 0; j < curr.size(); j++){
                curr.set(j, Math.min(prev.get(j), prev.get(j+1)) + curr.get(j));
            }
        }
        return triangle.get(0).get(0);
    }
}
// Time : O(N)
// Space : O(1)
