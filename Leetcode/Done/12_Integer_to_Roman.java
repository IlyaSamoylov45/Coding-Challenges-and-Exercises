// Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
//
// Symbol       Value
// I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000
// For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
//
// Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
//
// I can be placed before V (5) and X (10) to make 4 and 9.
// X can be placed before L (50) and C (100) to make 40 and 90.
// C can be placed before D (500) and M (1000) to make 400 and 900.
// Given an integer, convert it to a roman numeral.
//
//
//
// Example 1:
//
// Input: num = 3
// Output: "III"
// Example 2:
//
// Input: num = 4
// Output: "IV"
// Example 3:
//
// Input: num = 9
// Output: "IX"
// Example 4:
//
// Input: num = 58
// Output: "LVIII"
// Explanation: L = 50, V = 5, III = 3.
// Example 5:
//
// Input: num = 1994
// Output: "MCMXCIV"
// Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
//
//
// Constraints:
//
// 1 <= num <= 3999






class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        while(num > 0){
            if(num / 1000 != 0){
                sb.append("M");
                num -= 1000;
            }else if(num / 900 != 0){
                sb.append("CM");
                num -= 900;
            }else if(num / 500 != 0){
                sb.append("D");
                num -= 500;
            }else if(num / 400 != 0){
                sb.append("CD");
                num -= 400;
            }else if(num / 100 != 0){
                sb.append("C");
                num -= 100;
            }else if(num / 90 != 0){
                sb.append("XC");
                num -= 90;
            }else if(num / 50 != 0){
                sb.append("L");
                num -= 50;
            }else if(num / 40 != 0){
                sb.append("XL");
                num -= 40;
            }else if(num / 10 != 0){
                sb.append("X");
                num -= 10;
            }else if(num / 9 != 0){
                sb.append("IX");
                num -= 9;
            }else if(num / 5 != 0){
                sb.append("V");
                num -= 5;
            }else if(num / 4 != 0){
                sb.append("IV");
                num -= 4;
            }else{
                sb.append("I");
                num -= 1;
            }
        }

        return sb.toString();
    }
}
// Time : O(1)
// Space : O(1)






public static String intToRoman(int num) {
    String M[] = {"", "M", "MM", "MMM"};
    String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
}
// Time : O(1)
// Space : O(1)





class Solution {

    private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};


    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < values.length && num > 0; i++){
            while(num/values[i] > 0){
                num-=values[i];
                sb.append(symbols[i]);
            }
        }

        return sb.toString();
    }

}
// Time : O(1)
// Space : O(1)
