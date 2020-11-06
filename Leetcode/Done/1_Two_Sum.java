// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
// You can return the answer in any order.
//
//
//
// Example 1:
//
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Output: Because nums[0] + nums[1] == 9, we return [0, 1].
// Example 2:
//
// Input: nums = [3,2,4], target = 6
// Output: [1,2]
// Example 3:
//
// Input: nums = [3,3], target = 6
// Output: [0,1]
//
//
// Constraints:
//
// 2 <= nums.length <= 105
// -109 <= nums[i] <= 109
// -109 <= target <= 109
// Only one valid answer exists.

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> values = new HashMap<>();
        int[] sol = new int[2];
        for(int i = 0; i < nums.length; i++){
            if(values.containsKey(target - nums[i])){
                sol[0] = values.get(target - nums[i]);
                sol[1] = i;
                break;
            }
            values.put(nums[i], i);
        }
        return sol;
    }
}

// O(N) Space
// O(N) Time
