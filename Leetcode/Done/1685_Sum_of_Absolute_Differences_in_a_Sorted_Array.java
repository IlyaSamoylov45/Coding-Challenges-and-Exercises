// You are given an integer array nums sorted in non-decreasing order.
//
// Build and return an integer array result with the same length as nums such that result[i] is equal to the summation of absolute differences between nums[i] and all the other elements in the array.
//
// In other words, result[i] is equal to sum(|nums[i]-nums[j]|) where 0 <= j < nums.length and j != i (0-indexed).
//
//
//
// Example 1:
//
// Input: nums = [2,3,5]
// Output: [4,3,5]
// Explanation: Assuming the arrays are 0-indexed, then
// result[0] = |2-2| + |2-3| + |2-5| = 0 + 1 + 3 = 4,
// result[1] = |3-2| + |3-3| + |3-5| = 1 + 0 + 2 = 3,
// result[2] = |5-2| + |5-3| + |5-5| = 3 + 2 + 0 = 5.
// Example 2:
//
// Input: nums = [1,4,6,8,10]
// Output: [24,15,13,15,21]
//
//
// Constraints:
//
// 2 <= nums.length <= 105
// 1 <= nums[i] <= nums[i + 1] <= 104







class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] values = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){
                values[j] += Math.abs(nums[i] - nums[j]);
                values[i] += Math.abs(nums[i] - nums[j]);
            }
        }
        return values;

    }
}
// Time : O(N^2)
// Space : O(N)








class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] vals = new int[nums.length];
        int left = 0;
        int right = 0;
        for(int num : nums){
            right += num;
        }
        for(int i = 0; i < nums.length; i++){
            vals[i] = Math.abs(right - nums[i] * (nums.length - i));
            vals[i] += Math.abs(left - nums[i] * i);
            left += nums[i];
            right -= nums[i];
        }
        return vals;

    }
}
// Time : O(N)
// Space : O(1)







class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] vals = new int[nums.length];
        int left = 0;
        int right = 0;
        for(int num : nums){
            right += num;
        }
        for(int i = 0; i < nums.length; i++){
            right -= nums[i];
            vals[i] = right - nums[i] * (nums.length - i - 1);
            vals[i] += nums[i] * i - left;

            left += nums[i];
        }
        return vals;

    }
}
// Time : O(N)
// Space : O(1)









class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] vals = new int[nums.length];
        int left = 0;
        int right = 0;
        for(int num : nums){
            right += num;
        }
        for(int i = 0; i < nums.length; i++){
            right -= nums[i];
            vals[i] = right - left - nums[i] * (nums.length - 2*i - 1);

            left += nums[i];
        }
        return vals;

    }
}
// Time : O(N)
// Space : O(1)
