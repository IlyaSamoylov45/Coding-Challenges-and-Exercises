// Given an array of strings words, return the words that can be typed using letters of the alphabet on only one row of American keyboard like the image below.
//
// In the American keyboard:
//
// the first row consists of the characters "qwertyuiop",
// the second row consists of the characters "asdfghjkl", and
// the third row consists of the characters "zxcvbnm".
//
//
//
// Example 1:
//
// Input: words = ["Hello","Alaska","Dad","Peace"]
// Output: ["Alaska","Dad"]
// Example 2:
//
// Input: words = ["omk"]
// Output: []
// Example 3:
//
// Input: words = ["adsdf","sfd"]
// Output: ["adsdf","sfd"]
//
//
// Constraints:
//
// 1 <= words.length <= 20
// 1 <= words[i].length <= 100
// words[i] consists of English letters (both lowercase and uppercase).






class Solution {
    public String[] findWords(String[] words) {
        String[] rows = new String[]{"qwertyuiopQWERTYUIOP","asdfghjklASDFGHJKL","zxcvbnmZXCVBNM"};
        List<String> ret = new LinkedList<>();
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            int rowCount1 = 0;
            int rowCount2 = 0;
            int rowCount3 = 0;
            for(char c : word.toCharArray()){
                if(rows[0].contains("" + c)){
                    rowCount1++;
                }else if(rows[1].contains("" + c)){
                    rowCount2++;
                }else{
                    rowCount3++;
                }
            }

            if(rowCount1 == word.length() || rowCount2 == word.length() || rowCount3 == word.length() ){
                ret.add(word);
            }
        }
        return ret.toArray(new String[0]);

    }
}
// Time : O(N)
// Space : O(N)
