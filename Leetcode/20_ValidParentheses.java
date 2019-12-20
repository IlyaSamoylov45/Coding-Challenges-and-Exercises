/**
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
**/

class Solution {

    public Map<Character, Character> initialize(){
        Map<Character, Character> vals = new HashMap<>();
        vals.put(')', '(');
        vals.put('}', '{');
        vals.put(']', '[');
        return vals;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> vals = initialize();
        for(Character c : s.toCharArray()){
            if(vals.containsKey(c)){
                if(stack.isEmpty()){
                    return false;
                }
                if(stack.pop() != vals.get(c)){
                    return false;
                }
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
