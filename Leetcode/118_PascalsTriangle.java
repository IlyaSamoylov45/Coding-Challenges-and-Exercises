/**
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
**/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> vals = new ArrayList<>();
        if (numRows <= 0) {
            return vals;
        }
        vals.add(new ArrayList<>());
        vals.get(0).add(1);
        for(int i = 1; i < numRows; i++){
            List<Integer> currLevel = new ArrayList<>();
            List<Integer> prevLevel = vals.get(i - 1);
            currLevel.add(1);
            for(int j = 1; j < i; j++){
                currLevel.add(prevLevel.get(j - 1) + prevLevel.get(j));
            }
            currLevel.add(1);
            vals.add(new ArrayList<>(currLevel));
        }
        return vals;
    }
}
