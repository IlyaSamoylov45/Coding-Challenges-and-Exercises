// Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
//
// You can use each character in text at most once. Return the maximum number of instances that can be formed.
//
//
//
// Example 1:
//
//
//
// Input: text = "nlaebolko"
// Output: 1
// Example 2:
//
//
//
// Input: text = "loonbalxballpoon"
// Output: 2
// Example 3:
//
// Input: text = "leetcode"
// Output: 0
//
//
// Constraints:
//
// 1 <= text.length <= 10^4
// text consists of lower case English letters only.






class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] balloon = new int[5];
        for(char c : text.toCharArray()){
            switch(c){
                case 'b':
                    balloon[0]++;
                    break;
                case 'a':
                    balloon[1]++;
                    break;
                case 'l':
                    balloon[2]++;
                    break;
                case 'o':
                    balloon[3]++;
                    break;
                case 'n':
                    balloon[4]++;
                    break;
            }
        }
        int min = Math.min(balloon[0], balloon[1]);
        min = Math.min(min, balloon[2]/2);
        min = Math.min(min, balloon[3]/2);
        min = Math.min(min, balloon[4]);
        return min;
    }
}
// Time : O(N)
// Space : O(1)
