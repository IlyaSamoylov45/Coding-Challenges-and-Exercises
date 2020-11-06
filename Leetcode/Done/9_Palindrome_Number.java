// Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
//
// Follow up: Could you solve it without converting the integer to a string?
//
//
//
// Example 1:
//
// Input: x = 121
// Output: true
// Example 2:
//
// Input: x = -121
// Output: false
// Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
// Example 3:
//
// Input: x = 10
// Output: false
// Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
// Example 4:
//
// Input: x = -101
// Output: false
//
//
// Constraints:
//
// -231 <= x <= 231 - 1





class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        int len = (int)Math.log10(x);
        while(x != 0){
            if((int)(x/Math.pow(10, len)) != x%10){
                return false;
            }
            x %= Math.pow(10, len);
            len-=2;
            x /= 10;
        }
        return true;
    }
}

// Time Complexity Time complexity : O(log10(n))
// Space complexity : O(1).


class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int x2 = 0;
        while(x > x2){
            x2 *= 10;
            x2 += x%10;
            x/=10;
        }
        return x2 == x || x2/10 == x ;
    }
}
// Time Complexity Time complexity : O(log10(n))
// Space complexity : O(1).
