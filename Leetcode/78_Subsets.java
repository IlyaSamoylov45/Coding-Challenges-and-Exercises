/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        subsetsSupport(nums, 0, new ArrayList<>(), list);
        return list;
    }

    public void subsetsSupport(int[] nums, int i, List<Integer> curr, List<List<Integer>> list){
        if(i >= nums.length){
            list.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[i]);
        subsetsSupport(nums, i + 1, curr, list);
        curr.remove(curr.size() - 1);
        subsetsSupport(nums, i + 1, curr, list);
    }
}
