// Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
//
// Notice that the solution set must not contain duplicate quadruplets.
//
//
//
// Example 1:
//
// Input: nums = [1,0,-1,0,-2,2], target = 0
// Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// Example 2:
//
// Input: nums = [], target = 0
// Output: []
//
//
// Constraints:
//
// 0 <= nums.length <= 200
// -109 <= nums[i] <= 109
// -109 <= target <= 109




class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> values = new HashSet<>();
        Arrays.sort(nums);
        fourSum(nums, target, new LinkedList<>(), values, 0);
        return List.copyOf(values);
    }

    private void fourSum(int[] nums, int target, LinkedList<Integer> curr, Set<List<Integer>> values, int index){
        if(curr.size() == 4){
            if(target == 0){
                values.add(new LinkedList<>(curr));
            }
            return;
        }
        for(int i = index; i < nums.length; i++){
            curr.add(nums[i]);
            fourSum(nums, target - nums[i], curr, values, i + 1);
            curr.removeLast();
        }
    }
}
//Time : O(C(N choose 4))
//Space : O(C(N choose 4))

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    private List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
        List<List<Integer>> values = new ArrayList<>();
        if(start == nums.length || nums[start] * k > target || target > nums[nums.length - 1] * k){
            return values;
        }
        if(k == 2){
            return twoSum(nums, target, start);
        }
        for (int i = start; i < nums.length; ++i){
            if (i == start || nums[i - 1] != nums[i]){
                for (var set : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    values.add(new ArrayList<>(Arrays.asList(nums[i])));
                    values.get(values.size() - 1).addAll(set);
                }
            }
        }
        return values;
    }

    public List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> values = new ArrayList<>();
        Set<Integer> s = new HashSet<>();
        for (int i = start; i < nums.length; ++i) {
            if (values.isEmpty() || values.get(values.size() - 1).get(1) != nums[i]){
                if (s.contains(target - nums[i])){
                    values.add(Arrays.asList(target - nums[i], nums[i]));
                }
            }
            s.add(nums[i]);
        }
        return values;
    }
}
//Time : O(N^3)
//Space : O(N)



class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < num.length - 3; i++){
            if (i != 0 && (i > 0 && num[i] == num[i - 1])){
                continue;
            }
            for(int j = i + 1; j < num.length - 2; j++){
                if(j != i + 1 && num[j] == num[j-1]){
                    continue;
                }
                int sum = target - (num[i] + num[j]);
                int low = j + 1;
                int high = num.length - 1;
                while(low < high){
                    if(num[low] + num[high] == sum){
                        res.add(new ArrayList<>(Arrays.asList(num[i], num[j], num[low], num[high])));
                        while(low < high && num[low] == num[low+1]){
                            low++;
                        }
                        while(low < high && num[high] == num[high-1]){
                            high--;
                        }
                        low++;
                        high--;
                    }else if (num[low] + num[high] < sum){
                        low++;
                    }
                    else{
                        high--;
                    }
                }

            }
        }
        return res;
    }
}
//Time : O(N^3)
//Space : O(1)
