// You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
//
// Given n, find the total number of full staircase rows that can be formed.
//
// n is a non-negative integer and fits within the range of a 32-bit signed integer.
//
// Example 1:
//
// n = 5
//
// The coins can form the following rows:
// ¤
// ¤ ¤
// ¤ ¤
//
// Because the 3rd row is incomplete, we return 2.
// Example 2:
//
// n = 8
//
// The coins can form the following rows:
// ¤
// ¤ ¤
// ¤ ¤ ¤
// ¤ ¤
//
// Because the 4th row is incomplete, we return 3.






class Solution {
    public int arrangeCoins(int n) {
        if(n <= 0){
            return 0;
        }
        int i = 0;
        int count = 0;
        while(i++ < n){
            n -= i;
            count++;
        }
        return count;
    }
}
// Time : O(N)
// Space : O(1)





class Solution {
    public int arrangeCoins(int n) {
        long left = 0, right = n;
        long k, curr;
        while(left <= right){
            k = left + (right - left)/2;
            curr = k * (k+1)/2;
            if(curr == n){
                return (int)k;
            }
            if(n < curr){
                right = k - 1;
            }else{
                left = k + 1;
            }
        }
        return (int)right;
    }
}
// Time : O(LogN)
// Space : O(1)






class Solution {
    public int arrangeCoins(int n) {
        return (int)(Math.sqrt(2 * (long)n + 0.25) - 0.5);
    }
}
// Time : O(1)
// Space : O(1)
