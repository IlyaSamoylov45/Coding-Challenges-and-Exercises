// String permutations are the various possible strings made by the rearrangement of the characters in the original String.
//
// For example, the permutations of car are
//
// car, cra, acr, arc, rac, rca
// Write a recursive method getPermutations() that returns all permutations of an input String in an ArrayList. Define a helper method if needed. For the sake of simplicity, assume that all characters in the input String are unique.
//
// Examples:
//
// getPermutations("") -> ArrayList -> []
//
// getPermutations("c") -> ArrayList -> ["c"]
//
// getPermutations("cat") -> ArrayList -> ["cat","cta","act","atc","tca","tac"]*
//
// *Order does not matter.



// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static ArrayList<String> getPermutations(String s) {
    if(s == null){
        return null;
    }
    ArrayList<String> vals = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    boolean[] seen = new boolean[s.length()];
    getPermutations(vals, sb, s, seen);
    return vals;
}

public static void getPermutations(ArrayList<String> vals, StringBuilder sb, String s, boolean[] seen){
    if(sb.length() == s.length()){
        vals.add(sb.toString());
        return;
    }
    for(int i = 0; i < s.length(); i++){
        if(seen[i]){
            continue;
        }
        sb.append(s.charAt(i));
        seen[i] = true;
        getPermutations(vals, sb, s, seen);
        sb.setLength(sb.length()-1);
        seen[i] = false;
    }
}
// Time : O(n * n!)
// Space : O(n!)
