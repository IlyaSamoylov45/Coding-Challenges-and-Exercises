/*
Given a valid (IPv4) IP address, return a defanged version of that IP address.

A defanged IP address replaces every period "." with "[.]".



Example 1:

Input: address = "1.1.1.1"
Output: "1[.]1[.]1[.]1"
Example 2:

Input: address = "255.100.50.0"
Output: "255[.]100[.]50[.]0"
*/

class Solution {
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < address.length(); i++){
            char c = address.charAt(i);
            if(c != '.'){
                sb.append(c);
            }else{
                sb.append("[.]");
            }
        }
        return sb.toString();
    }
}
