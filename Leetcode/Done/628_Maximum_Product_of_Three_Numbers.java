// Given an integer array nums, find three numbers whose product is maximum and return the maximum product.
//
//
//
// Example 1:
//
// Input: nums = [1,2,3]
// Output: 6
// Example 2:
//
// Input: nums = [1,2,3,4]
// Output: 24
// Example 3:
//
// Input: nums = [-1,-2,-3]
// Output: -6
//
//
// Constraints:
//
// 3 <= nums.length <= 104
// -1000 <= nums[i] <= 1000






class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length - 1;
        return Math.max(nums[0] * nums[1] * nums[len], nums[len - 2] * nums[len - 1] * nums[len]);
    }
}
// Time : O(NLogN)
// Space : O(LogN)






class Solution {
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for(int num : nums){
            if (num <= min1) {
                min2 = min1;
                min1 = num;
            } else if (num <= min2) {
                min2 = num;
            }
            if(max1 < num){
                max3 = max2;
                max2 = max1;
                max1 = num;
            }else if(max2 < num){
                max3 = max2;
                max2 = num;
            }else if(max3 < num){
                max3 = num;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}
// Time : O(N)
// Space : O(1)
