// Given a String input, find the length of the longest substring that is made up of non-repeating characters. For ex, the longest substrings without repeated characters in “BCEFGHBCFG” are “CEFGHB” and “EFGHBC”, with length = 6. In the case of "FFFFF", the longest substring is "F" with a length of 1.
// Example:
//
// Input : aaabbbabcde
// Output: 5


// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static int longestNRSubstringLen(String input) {
    int max = 0;
    Set<Character> set = new HashSet<>();
    for(Character c : input.toCharArray()){
        if(!set.add(c)){
            max = Math.max(set.size(), max);
            set.clear();
        }
    }
    return Math.max(set.size(), max);
}
// Time : O(N)
// Space : O(N)
