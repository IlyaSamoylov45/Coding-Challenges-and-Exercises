// The product sum of two equal-length arrays a and b is equal to the sum of a[i] * b[i] for all 0 <= i < a.length (0-indexed).
//
// For example, if a = [1,2,3,4] and b = [5,2,3,1], the product sum would be 1*5 + 2*2 + 3*3 + 4*1 = 22.
// Given two arrays nums1 and nums2 of length n, return the minimum product sum if you are allowed to rearrange the order of the elements in nums1.
//
//
//
// Example 1:
//
// Input: nums1 = [5,3,4,2], nums2 = [4,2,2,5]
// Output: 40
// Explanation: We can rearrange nums1 to become [3,5,4,2]. The product sum of [3,5,4,2] and [4,2,2,5] is 3*4 + 5*2 + 4*2 + 2*5 = 40.
// Example 2:
//
// Input: nums1 = [2,1,4,5,7], nums2 = [3,2,4,8,6]
// Output: 65
// Explanation: We can rearrange nums1 to become [5,7,4,1,2]. The product sum of [5,7,4,1,2] and [3,2,4,8,6] is 5*3 + 7*2 + 4*4 + 1*8 + 2*6 = 65.
//
//
// Constraints:
//
// n == nums1.length == nums2.length
// 1 <= n <= 10^5
// 1 <= nums1[i], nums2[i] <= 100





class Solution {
    public int minProductSum(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> queue1 = new PriorityQueue<>();
        PriorityQueue<Integer> queue2 = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : nums1){
            queue1.add(num);
        }
        for(int num : nums2){
            queue2.add(num);
        }
        int product = 0;
        while(!queue1.isEmpty()){
            product += queue1.poll() * queue2.poll();
        }
        return product;
    }
}
// Time : O(NLogN)
//Space : O(N)





class Solution {
    public int minProductSum(int[] nums1, int[] nums2) {
        int[] bucket1 = new int[101];
        int[] bucket2 = new int[101];
        for(int i = 0; i < nums1.length; i++){
            bucket1[nums1[i]]++;
            bucket2[nums2[i]]++;
        }
        int product = 0;
        int i = 0;
        int j = bucket2.length - 1;
        while(i < bucket1.length){
            while(i < bucket1.length && bucket1[i] == 0){
                i++;
            }
            while(j >= 0 && bucket2[j] == 0){
                j--;
            }
            if(i < bucket1.length){
                product += i * j;
                bucket1[i]--;
                bucket2[j]--;
            }
        }
        return product;
    }
}
// Time : O(N)
// Space : O(1)







class Solution {
    public int minProductSum(int[] nums1, int[] nums2) {
        int[] bucket1 = new int[101];
        int[] bucket2 = new int[101];
        for(int i = 0; i < nums1.length; i++){
            bucket1[nums1[i]]++;
            bucket2[nums2[i]]++;
        }
        int product = 0;
        int i = 0;
        int j = bucket2.length - 1;
        while(i < bucket1.length && j >= 0){
            if(bucket1[i] > 0 && bucket2[j] > 0) {
                product += i * j;
                bucket1[i]--;
                bucket2[j]--;
            }
            if(bucket1[i] == 0){
                i++;
            }
            if(bucket2[j] == 0) {
                j--;
            }
        }
        return product;
    }
}
// Time : O(N)
// Space : O(1)
