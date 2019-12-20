/**
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
**/

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> vals = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithDup(nums, 0, vals, curr);
        return vals;
    }
    public void subsetsWithDup(int[] nums, int index, List<List<Integer>> vals, List<Integer> curr){
        if(index >= nums.length){
            if(!vals.contains(curr)){
                vals.add(new ArrayList<>(curr));
            }
            return;
        }
        for(int i = index; i < nums.length; i++){
            curr.add(nums[i]);
            subsetsWithDup(nums, i+1, vals, curr);
            curr.remove(curr.size() - 1);
            subsetsWithDup(nums, i+1, vals, curr);
        }
    }
}
