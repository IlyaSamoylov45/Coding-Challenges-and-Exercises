/*
Write a method to return all valid combinations of n-pairs of parentheses.

The method should return an ArrayList of strings, in which each string represents a valid combination of parentheses.

The order of the strings in the ArrayList does not matter.

Examples:
combParenthesis(2) ==> {"(())","()()"}

Note: Valid combination means that parentheses pairs are not left open. ")()(" is not a valid combination.
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.


public static ArrayList<String> combParenthesis(int pairs) {
    ArrayList<String> comb = new ArrayList<>();
    if(pairs <= 0){
        return comb;
    }
    char[] arr = new char[2*pairs];
    combParenthesisSupport(pairs, pairs, arr, comb, 0);
    return comb;
}

public static void combParenthesisSupport(int opened, int closed, char[] curr, ArrayList<String> comb, int i){
    if(i >= curr.length){
        comb.add(new String(curr));
        return;
    }
    if(opened > 0){
        curr[i] = '(';
        combParenthesisSupport(opened - 1, closed, curr, comb, i + 1);
    }
    if(closed > opened){
        curr[i] = ')';
        combParenthesisSupport(opened, closed - 1, curr, comb, i + 1);
    }

}
