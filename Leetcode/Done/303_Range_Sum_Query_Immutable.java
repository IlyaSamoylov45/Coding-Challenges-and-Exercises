// Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
//
// Implement the NumArray class:
//
// NumArray(int[] nums) Initializes the object with the integer array nums.
// int sumRange(int i, int j) Return the sum of the elements of the nums array in the range [i, j] inclusive (i.e., sum(nums[i], nums[i + 1], ... , nums[j]))
//
//
// Example 1:
//
// Input
// ["NumArray", "sumRange", "sumRange", "sumRange"]
// [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
// Output
// [null, 1, -1, -3]
//
// Explanation
// NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
// numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
// numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
// numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
//
//
// Constraints:
//
// 0 <= nums.length <= 104
// -105 <= nums[i] <= 105
// 0 <= i <= j < nums.length
// At most 104 calls will be made to sumRange.





/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
class NumArray {
    int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        for(int x = i; x <= j; x++){
            sum += nums[x];
        }
        return sum;
    }
}
 // Time : O(N)
 // Space : O(N)





 class NumArray {
    int[] sums;
    public NumArray(int[] nums) {
        this.sums = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++){
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}
// Time : O(1)
// Space : O(N)







class NumArray {
    int[] segmentTree;
    int n;
    public NumArray(int[] nums) {
        this.n = nums.length;
        int length = 0;
        if((n & (n - 1)) != 0){
            int pow = n;
            while((pow & (pow-1)) > 0){
                pow = pow & (pow-1);
            }
            pow<<=1;
            length = pow * 2 - 1;
        }else{
            length = n * 2 - 1;
        }
        segmentTree = new int[length];
        for(int i = 0; i < segmentTree.length; i++){
            segmentTree[i] = Integer.MAX_VALUE;
        }
        constructSegmentTree(nums, segmentTree, 0, n - 1, 0);
    }

     void constructSegmentTree(int[] nums, int[] segmentTree, int low, int high, int pos){
        if(low == high){
            segmentTree[pos] = nums[low];
            return;
        }
        int mid = low + (high - low)/2;
        constructSegmentTree(nums, segmentTree, low, mid, pos*2 + 1);
        constructSegmentTree(nums, segmentTree, mid + 1, high, pos*2 + 2);
        segmentTree[pos] = segmentTree[pos*2+1] + segmentTree[pos*2 + 2];

    }

    public int sumRange(int i, int j) {
        return getSegmentSum(segmentTree, i, j, 0, n - 1, 0);
    }

    int getSegmentSum(int[] segmentTree, int qlow, int qhigh, int low, int high, int pos){
        if(qlow <= low && qhigh >= high){
            return segmentTree[pos];
        }
        if(qlow > high || qhigh < low){
            return 0;
        }
        int mid = low + (high - low)/2;
        return getSegmentSum(segmentTree, qlow, qhigh, low, mid, pos*2+1) +
            getSegmentSum(segmentTree, qlow, qhigh, mid + 1, high, pos*2+2);
    }
}
// Time : O(NLogN)
// Space : O(N)
