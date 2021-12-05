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
// Time : O(N!(N-k)!)
// Space : O(N!)







class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        permute(nums, new LinkedHashSet<>(), permutations);
        return permutations;
    }

    private void permute(int[] nums, Set<Integer> current, List<List<Integer>> permutations){
        if(current.size() >= nums.length){
            permutations.add(new LinkedList<>(current));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!current.add(nums[i])){
                continue;
            }
            permute(nums, current, permutations);
            current.remove(nums[i]);
        }
    }
}
// Time : O(N!(N-k)!)
// Space : O(N!)






class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        List<Integer> current = new LinkedList<>();
        for(int num : nums){
            current.add(num);
        }
        permute(nums.length, current, permutations, 0);
        return permutations;
    }

    private void permute(int length, List<Integer> current, List<List<Integer>> permutations, int first){
        if(first == length){
            permutations.add(new LinkedList<>(current));
        }

        for(int i = first; i < length; i++){
            Collections.swap(current, first, i);
            permute(length, current, permutations, first + 1);
            Collections.swap(current, first, i);
        }
    }
}
// Time : O(N!(N-k)!)
// Space : O(N!)
