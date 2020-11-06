// You are given a sorted unique integer array nums.
//
// Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
//
// Each range [a,b] in the list should be output as:
//
// "a->b" if a != b
// "a" if a == b
//
//
// Example 1:
//
// Input: nums = [0,1,2,4,5,7]
// Output: ["0->2","4->5","7"]
// Explanation: The ranges are:
// [0,2] --> "0->2"
// [4,5] --> "4->5"
// [7,7] --> "7"
// Example 2:
//
// Input: nums = [0,2,3,4,6,8,9]
// Output: ["0","2->4","6","8->9"]
// Explanation: The ranges are:
// [0,0] --> "0"
// [2,4] --> "2->4"
// [6,6] --> "6"
// [8,9] --> "8->9"
// Example 3:
//
// Input: nums = []
// Output: []
// Example 4:
//
// Input: nums = [-1]
// Output: ["-1"]
// Example 5:
//
// Input: nums = [0]
// Output: ["0"]
//
//
// Constraints:
//
// 0 <= nums.length <= 20
// -2^31 <= nums[i] <= 2^31 - 1
// All the values of nums are unique.


class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> values = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            int start = nums[i];
            int end = i;
            while(end  + 1 < nums.length && start == nums[end + 1] - 1){
                start = nums[end + 1];
                end++;
            }
            String curr = Integer.toString(nums[i]);
            if(i != end){
                curr += "->" + Integer.toString(nums[end]);
            }
            values.add(curr);
            i = end;
        }
        return values;
    }
}
// Time : O(N)
// Space : O(1)





class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> values = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            int end = i;
            while(end + 1 < nums.length && nums[end] == nums[end + 1] - 1){
                end++;
            }
            StringBuilder curr = new StringBuilder(nums[i] + "");
            if(i != end){
                curr.append("->" + nums[end]);
            }
            values.add(curr.toString());
            i = end;
        }
        return values;
    }
}
// Time : O(N)
// Space : O(1)
