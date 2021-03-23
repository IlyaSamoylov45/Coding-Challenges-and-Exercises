// Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
//
// Implement KthLargest class:
//
// KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
// int add(int val) Returns the element representing the kth largest element in the stream.
//
//
// Example 1:
//
// Input
// ["KthLargest", "add", "add", "add", "add", "add"]
// [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
// Output
// [null, 4, 5, 5, 8, 8]
//
// Explanation
// KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
// kthLargest.add(3);   // return 4
// kthLargest.add(5);   // return 5
// kthLargest.add(10);  // return 5
// kthLargest.add(9);   // return 8
// kthLargest.add(4);   // return 8
//
//
// Constraints:
//
// 1 <= k <= 10^4
// 0 <= nums.length <= 10^4
// -10^4 <= nums[i] <= 10^4
// -10^4 <= val <= 10^4
// At most 10^4 calls will be made to add.
// It is guaranteed that there will be at least k elements in the array when you search for the kth element.








/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
class KthLargest {

    PriorityQueue<Integer> priorityQueue;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        priorityQueue = new PriorityQueue<>(k);
        for(int num : nums){
            add(num);
        }
    }

    public int add(int val) {
        if (priorityQueue.size() < this.k){
            priorityQueue.add(val);
        }else if (priorityQueue.peek() < val) {
                priorityQueue.poll();
                priorityQueue.offer(val);
        }
        return priorityQueue.peek();
    }
}
// Time : O(N)
// Space : O(N)
