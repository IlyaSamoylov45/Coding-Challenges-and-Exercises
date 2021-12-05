// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
//
// You must write an algorithm that runs in O(n) time.
//
//
//
// Example 1:
//
// Input: nums = [100,4,200,1,3,2]
// Output: 4
// Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
// Example 2:
//
// Input: nums = [0,3,7,2,5,8,4,6,0,1]
// Output: 9
//
//
// Constraints:
//
// 0 <= nums.length <= 10^5
// -10^9 <= nums[i] <= 10^9






class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int currentSequence = 1;
        int maxSequence = 1;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] + 1 == nums[i + 1]){
                currentSequence++;
            }
            else if(nums[i] != nums[i + 1]){
                currentSequence = 1;
            }
            maxSequence = Math.max(maxSequence, currentSequence);
        }
        return maxSequence;
    }
}
// Time : O(NLogN)
// Space : O(N)






class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int maxSequence = 1;
        for(int num : set){
            if(!set.contains(num - 1)){
                int currentSequence = 1;
                int current = num;
                while(set.contains(current + 1)){
                    currentSequence++;
                    current++;
                }
                maxSequence = Math.max(currentSequence, maxSequence);
            }
        }
        return maxSequence;
    }
}
// Time : O(N)
// Space : O(N)
