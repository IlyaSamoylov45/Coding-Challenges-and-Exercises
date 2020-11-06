// Given a set of distinct integers, nums, return all possible subsets (the power set).
//
// Note: The solution set must not contain duplicate subsets.
//
// Example:
//
// Input: nums = [1,2,3]
// Output:
// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]




class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> values = new LinkedList<>();
        subsets(nums, new LinkedList<>(), values, 0);
        return values;
    }

    private void subsets(int[] nums, LinkedList<Integer> curr, List<List<Integer>> values, int start){
        values.add(new LinkedList<>(curr));
        for(int i = start; i < nums.length; i++){
            curr.add(nums[i]);
            subsets(nums, curr, values, i + 1);
            curr.removeLast();
        }
    }
}
// Time : O(N * 2^N)
// Space : O(N * 2^N)
