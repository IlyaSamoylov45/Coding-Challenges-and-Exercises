// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
// An input string is valid if:
//
// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
//
//
// Example 1:
//
// Input: s = "()"
// Output: true
// Example 2:
//
// Input: s = "()[]{}"
// Output: true
// Example 3:
//
// Input: s = "(]"
// Output: false
// Example 4:
//
// Input: s = "([)]"
// Output: false
// Example 5:
//
// Input: s = "{[]}"
// Output: true
//
//
// Constraints:
//
// 1 <= s.length <= 104
// s consists of parentheses only '()[]{}'.

class Solution {
    Map<Character, Character> map;

    public Solution(){
        this.map = new HashMap<>();
        this.map.put('(',')');
        this.map.put('{','}');
        this.map.put('[',']');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(Character c : s.toCharArray()){
            if(c.equals('(') || c.equals('[') || c.equals('{')){
                stack.push(c);
            }else if(stack.isEmpty()){
                return false;
            }
            else if(map.get(stack.pop()) == c){
                continue;
            }else{
                return false;
            }
        }
        return stack.isEmpty();
    }
}
// Time : O(N)
// Space : O(N)




class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(Character c : s.toCharArray()){
            if(c == '('){
                stack.push(')');
            }else if(c == '{'){
                stack.push('}');
            }else if(c == '['){
                stack.push(']');
            }else if(stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
// Time : O(N)
// Space : O(N)
