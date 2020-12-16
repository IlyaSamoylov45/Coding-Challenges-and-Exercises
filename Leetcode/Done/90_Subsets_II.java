// Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
//
// Note: The solution set must not contain duplicate subsets.
//
// Example:
//
// Input: [1,2,2]
// Output:
// [
//   [2],
//   [1],
//   [1,2,2],
//   [2,2],
//   [1,2],
//   []
// ]




class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        subsetsWithDup(nums, new ArrayList<>(), subsets, 0);
        return new ArrayList<>(subsets);
    }

    private void subsetsWithDup(int[] nums, List<Integer> curr, List<List<Integer>> subsets, int index){
        subsets.add(new ArrayList<>(curr));
        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i-1]){
                continue;
            }
            curr.add(nums[i]);
            subsetsWithDup(nums, curr, subsets, i+1);
            curr.remove(curr.size()-1);
        }
    }
}
// Time: O(n * 2^n)
// Space: O(n * 2^n)
