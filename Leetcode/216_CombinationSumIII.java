/**
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:

All numbers will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]
**/
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> vals = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        combinationSum3(k, n, vals, curr, 1);
        return vals;

    }
    public void combinationSum3(int k, int n, List<List<Integer>> vals, List<Integer> curr, int index) {
        if(curr.size() == k){
            if(n == 0){
                vals.add(new ArrayList<>(curr));
            }
            return;
        }
        if(n < 0){
            return;
        }
        for(int i = index; i < 10; i++){
            curr.add(i);
            combinationSum3(k, n - i, vals, curr, i + 1);
            curr.remove(curr.size() - 1);
        }

    }

}
