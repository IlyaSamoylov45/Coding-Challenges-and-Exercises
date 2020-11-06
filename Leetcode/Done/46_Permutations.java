// Given a collection of distinct integers, return all possible permutations.
//
// Example:
//
// Input: [1,2,3]
// Output:
// [
//   [1,2,3],
//   [1,3,2],
//   [2,1,3],
//   [2,3,1],
//   [3,1,2],
//   [3,2,1]
// ]

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> values = new ArrayList<>();
        permute(nums, values, new ArrayList<>());
        return values;
    }

    private void permute(int[] nums, List<List<Integer>> values, List<Integer> curr){
        if(curr.size() == nums.length){
            values.add(new ArrayList<>(curr));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(curr.contains(nums[i])){
                continue;
            }
            curr.add(nums[i]);
            permute(nums,values,curr);
            curr.remove(curr.size() - 1);
        }
    }
}
// Time : O(N!)
// Space : O(N!)
