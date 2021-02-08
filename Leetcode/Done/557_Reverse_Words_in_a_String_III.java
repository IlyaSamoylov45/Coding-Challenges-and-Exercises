// Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
//
// Example 1:
// Input: "Let's take LeetCode contest"
// Output: "s'teL ekat edoCteeL tsetnoc"
// Note: In the string, each word is separated by single space and there will not be any extra space in the string.






class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        String prefix = "";
        while(i < s.length()){
            int j = i;
            while(j < s.length() && s.charAt(j) != ' '){
                j++;
            }
            sb.append(prefix);
            sb.append(reverseWord(i,j - 1,s));
            prefix = " ";
            i = j + 1;
        }
        return sb.toString();
    }

    private String reverseWord(int i, int j, String s){
        StringBuilder sb = new StringBuilder();
        while(j >= i){
            sb.append(s.charAt(j--));
        }
        return sb.toString();
    }
}
// Time : O(N)
// Space : O(N)







class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        int len = arr.length;
        while(i < len){
            int j = i;
            while(j < len && arr[j] != ' '){
                j++;
            }
            reverseWord(i,j - 1, arr);
            i = j + 1;
        }
        return new String(arr);
    }

    private void reverseWord(int i, int j, char[] arr){
        while(j >= i){
            char temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }
}
// Time : O(N)
// Space : O(N)
