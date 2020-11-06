// Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
//
// The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
//
// It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
//
//
//
// Example 1:
//
// Input: candidates = [2,3,6,7], target = 7
// Output: [[2,2,3],[7]]
// Explanation:
// 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
// 7 is a candidate, and 7 = 7.
// These are the only two combinations.
// Example 2:
//
// Input: candidates = [2,3,5], target = 8
// Output: [[2,2,2,2],[2,3,3],[3,5]]
// Example 3:
//
// Input: candidates = [2], target = 1
// Output: []
// Example 4:
//
// Input: candidates = [1], target = 1
// Output: [[1]]
// Example 5:
//
// Input: candidates = [1], target = 2
// Output: [[1,1]]
//
//
// Constraints:
//
// 1 <= candidates.length <= 30
// 1 <= candidates[i] <= 200
// All elements of candidates are distinct.
// 1 <= target <= 500


class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> values = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, values, new ArrayList<>(), 0);
        return values;
    }

    private void combinationSum(int[] candidates, int target, List<List<Integer>> values, List<Integer> curr, int index){
        if(target < 0){
            return;
        }
        if(target == 0){
            values.add(new ArrayList<>(curr));
            return;
        }
        for(int i = index; i < candidates.length; i++){
            if(target < candidates[i]){
                return;
            }
            curr.add(candidates[i]);
            combinationSum(candidates, target-candidates[i], values, curr, i);
            curr.remove(curr.size() - 1);
        }

    }
}
// Complexity analysis :
// Let N be the number of candidates, T be the target value, and M be the minimal value among the candidates.
// Here we provide a loose upper bound on the number of nodes.
//   First of all, the fan-out of each node would be bounded to N, i.e. the total number of candidates.
//   The maximal depth of the tree, would be T/M, where we keep on adding the smallest element to the combination.
//   As we know, the maximal number of nodes in N-ary tree of T/M, height would be N^(T/M + 1)
//   Note that, the actual number of nodes in the execution tree would be much smaller than the upper bound, since the fan-out of the nodes are decreasing level by level.
//
//
// Time : O(N^(T/M + 1))
// Space : O(T/M)
