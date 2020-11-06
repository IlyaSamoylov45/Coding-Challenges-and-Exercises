// The k-digit number N is an Armstrong number if and only if the k-th power of each digit sums to N.
//
// Given a positive integer N, return true if and only if it is an Armstrong number.
//
//
//
// Example 1:
//
// Input: 153
// Output: true
// Explanation:
// 153 is a 3-digit number, and 153 = 1^3 + 5^3 + 3^3.
// Example 2:
//
// Input: 123
// Output: false
// Explanation:
// 123 is a 3-digit number, and 123 != 1^3 + 2^3 + 3^3 = 36.
//
//
// Note:
//
// 1 <= N <= 10^8


class Solution {
    public boolean isArmstrong(int N) {
        int sum = 0;
        int pow = (int)Math.log10(N) + 1;
        int n = N;
        while(n > 0){
            sum += Math.pow(n%10, pow);
            n /= 10;
        }
        return sum == N;
    }
}

// Time : O(N)
// Space : O(1)
