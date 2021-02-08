// You have n  tiles, where each tile has one letter tiles[i] printed on it.
//
// Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.
//
//
//
// Example 1:
//
// Input: tiles = "AAB"
// Output: 8
// Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
// Example 2:
//
// Input: tiles = "AAABBC"
// Output: 188
// Example 3:
//
// Input: tiles = "V"
// Output: 1
//
//
// Constraints:
//
// 1 <= tiles.length <= 7
// tiles consists of uppercase English letters.





class Solution {

    int count = 0;

    public int numTilePossibilities(String tiles) {
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);
        boolean[] visited = new boolean[chars.length];
        numTilePossibilities(chars, visited);
        return count;
    }

    private void numTilePossibilities(char[] chars, boolean[] seen){
        for(int i = 0; i < chars.length; i++){
            if(seen[i]){
                continue;
            }
            if(i > 0 && chars[i] == chars[i-1] && !seen[i - 1]){
                continue;
            }
            count++;
            seen[i]=true;
            numTilePossibilities(chars, seen);
            seen[i]=false;

        }
    }
}
// Time : O(2^N)
// Space : O(N)






class Solution {

    public int numTilePossibilities(String tiles) {
        int[] vals = new int[26];
        for(char c : tiles.toCharArray()){
            vals[c-'A']++;
        }
        return dfs(vals);
    }

    private int dfs(int[] vals){
        int sum = 0;
        for(int i = 0; i < vals.length; i++){
            if(vals[i] <= 0){
                continue;
            }
            vals[i]--;
            sum++;
            sum += dfs(vals);
            vals[i]++;
        }
        return sum;
    }
}
// Time : O(2^N)
// Space : O(1)
