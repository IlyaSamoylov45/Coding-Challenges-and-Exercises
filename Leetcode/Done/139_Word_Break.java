// Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
//
// Note that the same word in the dictionary may be reused multiple times in the segmentation.
//
//
//
// Example 1:
//
// Input: s = "leetcode", wordDict = ["leet","code"]
// Output: true
// Explanation: Return true because "leetcode" can be segmented as "leet code".
// Example 2:
//
// Input: s = "applepenapple", wordDict = ["apple","pen"]
// Output: true
// Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
// Note that you are allowed to reuse a dictionary word.
// Example 3:
//
// Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
// Output: false
//
//
// Constraints:
//
// 1 <= s.length <= 300
// 1 <= wordDict.length <= 1000
// 1 <= wordDict[i].length <= 20
// s and wordDict[i] consist of only lowercase English letters.
// All the strings of wordDict are unique.




class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, new HashSet<>(wordDict), 0);
    }

    private boolean wordBreak(String s, Set<String> wordDict, int start){
        if(start == s.length()){
            return true;
        }
        for(int end = start + 1; end <= s.length(); end++){
            if(wordDict.contains(s.substring(start, end)) && wordBreak(s, wordDict, end)){
                return true;
            }
        }
        return false;
    }
}
// Time : O(2^N)
// Space : O(N)





class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }

    private boolean wordBreak(String s, Set<String> wordDict, int start, Boolean[] memo){
        if(start == s.length()){
            return true;
        }
        if(memo[start] != null){
            return memo[start];
        }
        for(int end = start + 1; end <= s.length(); end++){
            if(wordDict.contains(s.substring(start, end)) && wordBreak(s, wordDict, end, memo)){
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }



}

// Time : O(N^3)
// Space : O(N)






class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && wordDictSet.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
// Time : O(N^3)
// Space : O(N)
