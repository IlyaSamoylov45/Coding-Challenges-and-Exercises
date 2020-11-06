// Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//
// Notice that the solution set must not contain duplicate triplets.
//
//
//
// Example 1:
//
// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]
// Example 2:
//
// Input: nums = []
// Output: []
// Example 3:
//
// Input: nums = [0]
// Output: []
//
//
// Constraints:
//
// 0 <= nums.length <= 3000
// -10^5 <= nums[i] <= 10^5




class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> values = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++){
            if(i != 0 && (i > 0 && nums[i] == nums[i-1])){
                continue;
            }
            if(nums[i] > 0){
              break;
            }
            twoSum(nums, i, values);
        }
        return values;
    }

    private void twoSum(int[] nums, int start, List<List<Integer>> values){
        Set<Integer> set = new HashSet<>();
        for(int i = start + 1; i < nums.length; i++){
            int complement = -nums[start] - nums[i];
            if(set.contains(complement)){
                values.add(new ArrayList<>(Arrays.asList(nums[start], nums[i], complement)));
                while (i + 1 < nums.length && nums[i] == nums[i + 1]){
                    i++;
                }
            }
            set.add(nums[i]);
        }
    }
}
// Time : O(N^2)
// Spaec : O (N)







class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> values = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++){
            if(i != 0 && (i > 0 && nums[i] == nums[i-1])){
                continue;
            }
            if(nums[i] > 0){
              break;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                if(nums[i] + nums[left] + nums[right] == 0){
                    values.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));

                    while(left < right && nums[left] == nums[left + 1]){
                        left++;
                    }
                    while(right < left && nums[right] == nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }
                else if(nums[i] + nums[left] + nums[right] < 0){
                   left++;
                }else{
                    right--;
                }
            }
        }
        return values;
    }
}
// Time : O(N^2)
// Space : O(1)
