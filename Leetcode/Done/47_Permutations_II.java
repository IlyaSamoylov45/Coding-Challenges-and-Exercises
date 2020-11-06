// Given a collection of numbers that might contain duplicates, return all possible unique permutations.
//
// Example:
//
// Input: [1,1,2]
// Output:
// [
//   [1,1,2],
//   [1,2,1],
//   [2,1,1]
// ]


class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] seen = new boolean[nums.length];
        Set<List<Integer>> values = new HashSet<>();
        permuteUnique(nums, seen, values, new ArrayList<>());
        return List.copyOf(values);

    }

    private void permuteUnique(int[] nums, boolean[] seen,  Set<List<Integer>> values, List<Integer> curr){
        if(curr.size() == nums.length){
            if(!values.contains(curr)){
                values.add(new ArrayList<>(curr));
            }
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!seen[i]){
                seen[i] = true;
                curr.add(nums[i]);
                permuteUnique(nums, seen, values, curr);
                seen[i] = false;
                curr.remove(curr.size() - 1);
            }
        }
    }
}

// Time : O(N * N!)
// Space : O(N)

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<List<Integer>> values = new HashSet<>();
        for(Integer i : nums){
            map.put(i, (map.getOrDefault(i, 0) + 1));
        }
        permuteUnique(nums, map, values, new LinkedList<>());

        return List.copyOf(values);
    }

    private void permuteUnique(int[] nums, Map<Integer, Integer> map, Set<List<Integer>> values, List<Integer> curr){
        if(curr.size() == nums.length){
            values.add(new LinkedList<>(curr));
            return;
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int count = entry.getValue();
            int key = entry.getKey();

            if(count != 0){
                curr.add(key);
                entry.setValue(count - 1);
                permuteUnique(nums, map, values, curr);
                curr.remove(curr.size() - 1);
                entry.setValue(count);
            }

        }
    }

}
// Time O(N * N!)
// Space O(N)
