/**
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
**/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> currList = new LinkedList<>();
        List<List<Integer>> vals = new LinkedList<>();
        combinationSumSupport(currList, vals, candidates, 0, target);
        return vals;
    }

    public void combinationSumSupport(List<Integer> currList, List<List<Integer>> vals, int[] candidates, int index, int target){
        if(target == 0){
            vals.add(new LinkedList<>(currList));
            return;
        }
        if(index >= candidates.length || target < 0){
            return;
        }
        for(int i = index; i < candidates.length; i++){
            currList.add(candidates[i]);
            combinationSumSupport(currList, vals, candidates, i, target-candidates[i]);
            currList.remove(currList.size() - 1);
        }


    }
}
