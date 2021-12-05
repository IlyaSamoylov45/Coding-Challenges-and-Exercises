// Given an array of integers nums, half of the integers in nums are odd, and the other half are even.
//
// Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.
//
// Return any answer array that satisfies this condition.
//
//
//
// Example 1:
//
// Input: nums = [4,2,5,7]
// Output: [4,5,2,7]
// Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
// Example 2:
//
// Input: nums = [2,3]
// Output: [2,3]
//
//
// Constraints:
//
// 2 <= nums.length <= 2 * 104
// nums.length is even.
// Half of the integers in nums are even.
// 0 <= nums[i] <= 1000






class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int N = nums.length;
        int[] ans = new int[N];

        int t = 0;
        for (int x: nums){
            if (x % 2 == 0) {
                ans[t] = x;
                t += 2;
            }
        }

        t = 1;
        for (int x: nums){
            if (x % 2 == 1) {
                ans[t] = x;
                t += 2;
            }
        }
        return ans;
    }
}
// Time : O(N)
// Space : O(N)






class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int i = 0;
        int j = 1;
        while(i < nums.length){
            if(nums[i]%2 == 1){
                while (nums[j] % 2 == 1){
                    j += 2;
                }
                swap(i, j, nums);

            }
            i+=2;
        }
        return nums;
    }

    private void swap(int i, int j, int[] nums){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
// Time : O(N)
// Space : O(1)
