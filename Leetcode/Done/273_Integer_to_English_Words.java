// Convert a non-negative integer num to its English words representation.
//
//
//
// Example 1:
//
// Input: num = 123
// Output: "One Hundred Twenty Three"
// Example 2:
//
// Input: num = 12345
// Output: "Twelve Thousand Three Hundred Forty Five"
// Example 3:
//
// Input: num = 1234567
// Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
// Example 4:
//
// Input: num = 1234567891
// Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
//
//
// Constraints:
//
// 0 <= num <= 2^31 - 1






class Solution {

    private Map<Integer, String> map = initialize();

    public String numberToWords(int num) {
        if(num == 0){
            return map.get(0);
        }
        int billion = num / 1000000000;
        int million = (num - billion * 1000000000) / 1000000;
        int thousand = (num - billion * 1000000000 - million * 1000000) / 1000;
        int rest = num - billion * 1000000000 - million * 1000000 - thousand * 1000;

        StringBuilder sb = new StringBuilder();
        if(billion > 0){
            sb.append(threeDigit(billion)).append("Billion");
        }
        if(million > 0){
            sb.append(threeDigit(million)).append("Million");
        }
        if(thousand > 0){
            sb.append(threeDigit(thousand)).append("Thousand");
        }
        sb.append(threeDigit(rest));
        for(int i = 1; i < sb.length(); i++){
            char c = sb.charAt(i);
            if(c >= 'A' && c <= 'Z'){
                sb.insert(i, " ");
                i++;
            }
        }
        return sb.toString();
    }

    private String threeDigit(int digits){
        StringBuilder sb = new StringBuilder();
        if(digits >= 100){
            sb.append(map.get(digits / 100)).append("Hundred");
            digits %= 100;
        }
        sb.append(twoDigit(digits));
        return sb.toString();
    }


    private String twoDigit(int digits){
        if(digits == 0){
            return "";
        }
        if(digits < 10){
            return map.get(digits);
        }
        if(map.containsKey(digits)){
            return map.get(digits);
        }
        int remainder = digits % 10;
        return map.get(digits-digits%10) + oneDigit(remainder);
    }


    private String oneDigit(int digit){
        if(digit <= 0){
            return "";
        }
        return map.get(digit);
    }

    private Map<Integer, String> initialize(){
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "Zero");
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");

        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");

        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");

        map.put(100, "Hundred");
        map.put(1000, "Thousand");
        map.put(1000000, "Million");
        map.put(1000000000, "Billion");

        return map;
    }
}
// Time : O (N)
// Space : O(1)






class Solution {

    private Map<Integer, String> map = initialize();

    public String numberToWords(int num) {
        if(num == 0){
            return map.get(0);
        }
        int billion = num / 1000000000;
        int million = (num - billion * 1000000000) / 1000000;
        int thousand = (num - billion * 1000000000 - million * 1000000) / 1000;
        int rest = num - billion * 1000000000 - million * 1000000 - thousand * 1000;

        StringBuilder sb = new StringBuilder();
        if(billion > 0){
            sb.append(threeDigit(billion)).append(" Billion");
        }
        if(million > 0){
            if (sb.length() != 0){
                sb.append(" ");
            }
            sb.append(threeDigit(million)).append(" Million");
        }
        if(thousand > 0){
            if (sb.length() != 0){
                sb.append(" ");
            }
            sb.append(threeDigit(thousand)).append(" Thousand");
        }
        if (sb.length() != 0 && rest > 0){
            sb.append(" ");
        }
        sb.append(threeDigit(rest));

        return sb.toString();
    }

    private String threeDigit(int digits){
        StringBuilder sb = new StringBuilder();
        int hundred = digits / 100;
        int rest = digits - hundred * 100;
        if(hundred*rest != 0){
            sb.append(map.get(hundred)).append(" Hundred ").append(twoDigit(rest));
        }else if(hundred == 0 && rest != 0){
            sb.append(twoDigit(rest));
        }else if(hundred != 0 && rest == 0){
             sb.append(map.get(hundred)).append(" Hundred");
        }

        return sb.toString();
    }


    private String twoDigit(int digits){
        if(digits == 0){
            return "";
        }
        if(digits < 10){
            return map.get(digits);
        }
        if(map.containsKey(digits)){
            return map.get(digits);
        }
        int remainder = digits % 10;
        if(remainder != 0){
            return map.get(digits-digits%10) + " " + oneDigit(remainder);
        }else{
            return map.get(digits/10);
        }
    }


    private String oneDigit(int digit){
        if(digit <= 0){
            return "";
        }
        return map.get(digit);
    }

    private Map<Integer, String> initialize(){
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "Zero");
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");

        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");

        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");

        map.put(100, "Hundred");
        map.put(1000, "Thousand");
        map.put(1000000, "Million");
        map.put(1000000000, "Billion");

        return map;
    }
}
// Time : O (N)
// Space : O(1)
