/*
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> vals = new LinkedList<>();
        permuteSupport(nums, new LinkedList<>(), vals);
        return vals;
    }
    public void permuteSupport(int[] nums, LinkedList<Integer> curr, List<List<Integer>> vals){
        if(curr.size() >= nums.length){
            vals.add(new LinkedList<>(curr));
            return;
        }
        for(int i = 0; i < nums.length; i++ ){
            if(curr.contains(nums[i])){
                continue;
            }
            curr.add(nums[i]);
            permuteSupport(nums, curr, vals);
            curr.remove(curr.size()-1);
        }
    }
}
