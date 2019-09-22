/*
You have a set of tiles, where each tile has one letter tiles[i] printed on it.  Return the number of possible non-empty sequences of letters you can make.



Example 1:

Input: "AAB"
Output: 8
Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
Example 2:

Input: "AAABBC"
Output: 188


Note:

1 <= tiles.length <= 7
tiles consists of uppercase English letters.
*/

class Solution {
    public int numTilePossibilities(String tiles) {
        int[] ch = new int[26];
        for(int i = 0; i < tiles.length(); i++){
            ch[tiles.charAt(i) - 'A']++;
        }
        return numTilePossibilitiesSupport(ch);
    }

    public int numTilePossibilitiesSupport(int[] ch) {
        int sum = 0;
        for(int i = 0; i < 26; i++){
            if(ch[i] == 0){
                continue;
            }
            ch[i]--;
            sum += numTilePossibilitiesSupport(ch);
            ch[i]++;
            sum++;
        }
        return sum;
    }
}
