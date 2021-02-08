// Given an integer n, add a dot (".") as the thousands separator and return it in string format.
//
//
//
// Example 1:
//
// Input: n = 987
// Output: "987"
// Example 2:
//
// Input: n = 1234
// Output: "1.234"
// Example 3:
//
// Input: n = 123456789
// Output: "123.456.789"
// Example 4:
//
// Input: n = 0
// Output: "0"
//
//
// Constraints:
//
// 0 <= n < 2^31







class Solution {
    public String thousandSeparator(int n) {
        if(n < 1000){
            return "" + n;
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while(n > 0){
            if(count == 3){
                count=0;
                sb.append(".");
            }
            count++;
            sb.append(n%10);
            n /= 10;
        }
        return sb.reverse().toString();
    }
}
// Time : O(N)
// Space : O(N)
