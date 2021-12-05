// Given an array of strings words, return true if it forms a valid word square.
//
// A sequence of strings forms a valid word square if the kth row and column read the same string, where 0 <= k < max(numRows, numColumns).
//
//
//
// Example 1:
//
//
// Input: words = ["abcd","bnrt","crmy","dtye"]
// Output: true
// Explanation:
// The 1st row and 1st column both read "abcd".
// The 2nd row and 2nd column both read "bnrt".
// The 3rd row and 3rd column both read "crmy".
// The 4th row and 4th column both read "dtye".
// Therefore, it is a valid word square.
// Example 2:
//
//
// Input: words = ["abcd","bnrt","crm","dt"]
// Output: true
// Explanation:
// The 1st row and 1st column both read "abcd".
// The 2nd row and 2nd column both read "bnrt".
// The 3rd row and 3rd column both read "crm".
// The 4th row and 4th column both read "dt".
// Therefore, it is a valid word square.
// Example 3:
//
//
// Input: words = ["ball","area","read","lady"]
// Output: false
// Explanation:
// The 3rd row reads "read" while the 3rd column reads "lead".
// Therefore, it is NOT a valid word square.
//
//
// Constraints:
//
// 1 <= words.length <= 500
// 1 <= words[i].length <= 500
// words[i] consists of only lowercase English letters.






class Solution {
    public boolean validWordSquare(List<String> words) {

        int n = words.size();
        for(int i = 0; i < n; i++){
            String curr = words.get(i);

            for(int j = 0; j < curr.length(); j++){
                if(j >= n){
                    return false;
                }
                String next = words.get(j);
                if(next.length() <= i || next.charAt(i) != curr.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }
}
// Time : O(N)
// Space : O(1)
