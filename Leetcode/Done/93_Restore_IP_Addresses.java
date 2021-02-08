// Given a string s containing only digits, return all possible valid IP addresses that can be obtained from s. You can return them in any order.
//
// A valid IP address consists of exactly four integers, each integer is between 0 and 255, separated by single dots and cannot have leading zeros. For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses and "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
//
//
//
// Example 1:
//
// Input: s = "25525511135"
// Output: ["255.255.11.135","255.255.111.35"]
// Example 2:
//
// Input: s = "0000"
// Output: ["0.0.0.0"]
// Example 3:
//
// Input: s = "1111"
// Output: ["1.1.1.1"]
// Example 4:
//
// Input: s = "010010"
// Output: ["0.10.0.10","0.100.1.0"]
// Example 5:
//
// Input: s = "101023"
// Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
//
//
// Constraints:
//
// 0 <= s.length <= 3000
// s consists of digits only.






class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> restoredIp = new LinkedList<String>();
        restoreIpAddresses(s, restoredIp, 0, "", 0);
        return restoredIp;
    }

    private void restoreIpAddresses(String s, List<String> restoredIp, int start, String current, int count){
        if(count > 4){
            return;
        }
        if(count == 4 && start >= s.length()){
            restoredIp.add(current.substring(1, current.length()));
            return;
        }
        for(int i = start; i < s.length() && i <= start + 3; i++){
            String x = s.substring(start, i+1);
            if(!(x.charAt(0) == '0' && x.length() > 1) && !(Integer.parseInt(x) > 255)){
                restoreIpAddresses(s , restoredIp, i+1, current+"."+x, count + 1);
            }
        }
    }
}
// Time complexity: O(3^4)
// Space complexity: O(1)






class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> restoredIp = new LinkedList<String>();
        int n = s.length();
        for(int i = 1; i < n && i <= 3; i++){
            for(int j = i + 1; j < n && j <= i+3; j++){
                for(int k = j + 1; k < n && k <= j+3; k++){
                    String w = s.substring(0, i);
                    String x = s.substring(i, j);
                    String y = s.substring(j, k);
                    String z = s.substring(k, n);

                    if(valid(w) && valid(x) && valid(y) && valid(z)){
                        restoredIp.add(w + "." + x + "." + y + "." + z);
                    }
                }
            }
        }
        return restoredIp;
    }

    private boolean valid(String x){
        if(x.charAt(0) == '0' && x.length() > 1){
            return false;
        }
        if(x.length() > 3 || Integer.valueOf(x) > 255){
            return false;
        }
        return true;
    }
}
// Time complexity: O(3^4)
// Space complexity: O(1)
