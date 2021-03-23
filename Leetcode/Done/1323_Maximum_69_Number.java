// Given a positive integer num consisting only of digits 6 and 9.
//
// Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).
//
//
//
// Example 1:
//
// Input: num = 9669
// Output: 9969
// Explanation:
// Changing the first digit results in 6669.
// Changing the second digit results in 9969.
// Changing the third digit results in 9699.
// Changing the fourth digit results in 9666.
// The maximum number is 9969.
// Example 2:
//
// Input: num = 9996
// Output: 9999
// Explanation: Changing the last digit 6 to 9 results in the maximum number.
// Example 3:
//
// Input: num = 9999
// Output: 9999
// Explanation: It is better not to apply any change.
//
//
// Constraints:
//
// 1 <= num <= 10^4
// num's digits are 6 or 9.





class Solution {
    public int maximum69Number (int num) {
        int len = (int)Math.floor(Math.log10(num)) + 1;
        int val = 0;
        boolean changed = false;
        while(num != 0 && !changed){
            int tens = (int)Math.pow(10,len - 1);
            int digit = num/tens;
            if(!changed && digit == 6){
                changed = true;
                digit = 9;
            }
            val += (digit * tens);
            num%=tens;
            len--;
            System.out.println(val);
        }
        return val + num;
    }
}
// Time : O(N)
// Space : O(N)







class Solution {
    public int maximum69Number (int num) {
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        for(int i = 0; i < sb.length(); i++){
            if(sb.charAt(i) == '6'){
                sb.setCharAt(i, '9');
                break;
            }
        }
        return Integer.parseInt(sb.toString());
    }
}
// Time : O(N)
// Space : O(N)








class Solution {
    public int maximum69Number (int num) {
        char[] chars = Integer.toString(num).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '6') {
                chars[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(chars));
    }
}
// Time : O(N)
// Space : O(N)







class Solution {
    public int maximum69Number (int num) {
        return Integer.parseInt(String.valueOf(num).replaceFirst("6","9"));
    }
}
// Time : O(N)
// Space : O(N)
