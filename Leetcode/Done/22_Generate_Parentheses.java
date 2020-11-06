// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
//
//
// Example 1:
//
// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2:
//
// Input: n = 1
// Output: ["()"]
//
//
// Constraints:
//
// 1 <= n <= 8


class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> combs = new ArrayList<>();
        char[] parenthesis = new char[n*2];
        generateParenthesis(n,n,0,parenthesis,combs);
        return combs;
    }

    private void generateParenthesis(int left, int right, int index, char[] parenthesis, List<String> combs){
        if(left == 0 && right == 0){
            combs.add(new String(parenthesis));
            return;
        }
        if(left > 0){
            parenthesis[index++]='(';
            generateParenthesis(left-1,right,index,parenthesis,combs);
            index--;
        }
        if(right > left){
            parenthesis[index++]=')';
            generateParenthesis(left,right-1,index,parenthesis,combs);
            index--;
        }
    }
}
// Time : O(4^n/sqrt(n))
// Space : O(4^n/sqrt(n))
