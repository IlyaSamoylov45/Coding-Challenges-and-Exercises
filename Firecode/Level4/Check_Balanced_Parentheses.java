// Write a method to recursively check whether an equation has a balanced number of left and right parentheses and brackets - (including (,),[,],{,}).
//
// Examples:
// isBalanced("() [] ()") ==> true
// isBalanced("([)]") ==> false



// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static boolean isBalanced(String input) {
    Stack<Character> stack = new Stack<>();
    for(char c : input.toCharArray()){
        if( c == '('){
            stack.push(')');
        }else if(c == '{'){
            stack.push('}');
        }else if(c == '['){
            stack.push(']');
        }else{
            if(stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }
    }

    return stack.isEmpty();

}
// Time : O(N)
// Space : O(N)







private static String open  = "([<{";
private static String close = ")]>}";

public static boolean isBalanced(String input) {
    return isBalanced(input, "");
}

public static boolean isBalanced(String input, String stack){
    if(input.isEmpty()){
        return stack.isEmpty();
    }
    if(open.contains("" + input.charAt(0))){
        return isBalanced(input.substring(1), input.charAt(0) + stack);
    }
    return (!stack.isEmpty() && isMatching(stack.charAt(0), input.charAt(0))
                && isBalanced(input.substring(1), stack.substring(1)));
}

 public static boolean isMatching(char chOpen, char chClose) {
        return open.indexOf(chOpen) == close.indexOf(chClose);
}

// Time : O(N)
// Space : O(N)
