// Given a string, list all possible combinations and permutations of its characters.
//
// Examples:
// getCombPerms("a") ==> {"a"}
//
// getCombPerms("ab") ==> {"a","ab","ba","b"}



public static ArrayList<String> getCombPerms(String s) {
    if(s == null){
        return null;
    }
    boolean[] seen = new boolean[s.length()];
    ArrayList<String> combs = new ArrayList<>();
    getCombPerms(s, seen, combs, "");
    return combs;
}


private static void getCombPerms(String s, boolean[] seen, ArrayList<String> vals, String current){
    if(current != null && !current.isEmpty()){
        vals.add(current);
    }
    for(int i = 0; i < s.length(); i++){
        if(seen[i]){
            continue;
        }
        seen[i] = true;
        getCombPerms(s, seen, vals, current + s.charAt(i));
        seen[i] = false;
    }
}
