/**
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
**/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> vals = new ArrayList<String>();
        generateParenthesis(vals, "", 0, 0, n);
        return vals;
    }

    public void generateParenthesis(List<String> vals, String curr, int open, int close, int n){
        if(curr.length() == n * 2){
            vals.add(curr);
            return;
        }
        if(open < n){
            generateParenthesis(vals, curr+"(",open + 1, close, n);
        }
        if(close < open){
            generateParenthesis(vals, curr+")",open, close + 1, n);
        }
    }

}
