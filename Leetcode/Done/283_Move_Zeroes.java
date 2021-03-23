// Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//
// Example:
//
// Input: [0,1,0,3,12]
// Output: [1,3,12,0,0]
// Note:
//
// You must do this in-place without making a copy of the array.
// Minimize the total number of operations.







class Solution {
    public void moveZeroes(int[] nums) {
        int[] arr = new int[nums.length];
        int i = 0;
        for(int x : nums){
            if(x != 0){
                arr[i++] = x;
            }
        }
        i = 0;
        for(int x : arr){
            nums[i++] = x;
        }
    }
}
// Time : O(N)
// Space : O(N)







class Solution {
    public void moveZeroes(int[] nums) {
        for(int i = 0, current = 0; current < nums.length; current++){
            if(nums[current] != 0){
                int temp = nums[i];
                nums[i] = nums[current];
                nums[current] = temp;
                i++;
            }
        }
    }
}
// Time : O(N)
// Space : O(1)







class Solution {
    public void moveZeroes(int[] nums) {
        int snowBall = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                snowBall++;
            }else{
                int temp = nums[i];
                nums[i] = 0;
                nums[i - snowBall] = temp;
            }
        }
    }
}
// Time : O(N)
// Space : O(1)
