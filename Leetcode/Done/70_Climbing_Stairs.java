// You are climbing a stair case. It takes n steps to reach to the top.
//
// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//
// Example 1:
//
// Input: 2
// Output: 2
// Explanation: There are two ways to climb to the top.
// 1. 1 step + 1 step
// 2. 2 steps
// Example 2:
//
// Input: 3
// Output: 3
// Explanation: There are three ways to climb to the top.
// 1. 1 step + 1 step + 1 step
// 2. 1 step + 2 steps
// 3. 2 steps + 1 step
//
//
// Constraints:
//
// 1 <= n <= 45




class Solution {
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        int first = 1;
        int second = 2;
        for(int i = 2; i < n; i++){
            int temp = first + second;
            first = second;
            second = temp;
        }
        return second;
    }
}
// Time : O(N)
// Space : O(1)


class Solution {
    public int climbStairs(int n) {
        return (int) ((1/Math.sqrt(5))*(Math.pow((1+Math.sqrt(5))/2,  n + 1)-Math.pow((1-Math.sqrt(5))/2, n + 1)));
    }
}
// Time : O(log(N))
// Space : O(1)
