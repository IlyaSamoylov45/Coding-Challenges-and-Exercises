// Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.
//
//
//
// Example 1:
//
// Input: n = 5
// Output: true
// Explanation: The binary representation of 5 is: 101
// Example 2:
//
// Input: n = 7
// Output: false
// Explanation: The binary representation of 7 is: 111.
// Example 3:
//
// Input: n = 11
// Output: false
// Explanation: The binary representation of 11 is: 1011.
// Example 4:
//
// Input: n = 10
// Output: true
// Explanation: The binary representation of 10 is: 1010.
// Example 5:
//
// Input: n = 3
// Output: false
//
//
// Constraints:
//
// 1 <= n <= 2^31 - 1







class Solution {
    public boolean hasAlternatingBits(int n) {
        int one = n%2;
        n>>=1;
        while(n!=0){
            int curr = n%2;
            if(one == curr){
                return false;
            }
            one = curr;
            n>>=1;
        }
        return true;
    }
}
// Time : O (1)
// Space : O(1)







class Solution {
    public boolean hasAlternatingBits(int n) {
        int temp = (n >> 1) + n;
        return (temp & (temp + 1)) == 0;
    }
}
// Time : O (1)
// Space : O(1)







class Solution {
    public boolean hasAlternatingBits(int n) {
        return (n & (n >> 1)) == 0 && (n & (n >> 2)) == (n >> 2);

    }
}
// Time : O (1)
// Space : O(1)
