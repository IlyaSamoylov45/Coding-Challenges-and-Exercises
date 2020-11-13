// Given a String that represents the digits pressed on a classic cell phone keypad - return all possible letter combinations that the numbers could represent in an ArrayList of Strings. Check out the keypad and mapping below for reference.
//
// Note:
// a) You can assume that the input String contains only numbers between 2 and 9.
// b) The order of the combinations in the output does not matter.
//
// Mapping:
// 2 -> "abc"
// 3 -> "def"
// 4 -> "ghi"
// 5 -> "jkl"
// 6 -> "mno"
// 7 -> "pqrs"
// 8 -> "tuv"
// 9 -> "wxyz"
//
// Example:
// Input  : "34"
// Output : [dg, dh, di, eg, eh, ei, fg, fh, fi]


// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static  ArrayList<String> getStringsFromNums(String digits) {
    if(digits == null){
        return null;
    }
    Map<Character, String> values = new HashMap<>();
    values.put('2',"abc");
    values.put('3',"def");
    values.put('4',"ghi");
    values.put('5',"jkl");
    values.put('6',"mno");
    values.put('7',"pqrs");
    values.put('8',"tuv");
    values.put('9',"wxyz");
    ArrayList<String> ret = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    getStringsFromNums(digits, ret, sb, values, 0);
    return ret;
}

private static void getStringsFromNums(String digits, ArrayList<String> ret, StringBuilder sb, Map<Character, String> values, int index){
    if(sb.length() == digits.length()){
        ret.add(sb.toString());
        return;
    }
    for(Character c : values.get(digits.charAt(index)).toCharArray()){
        sb.append(c);
        getStringsFromNums(digits, ret, sb, values, index + 1);
        sb.setLength(sb.length() -1);

    }
}
//Time:O(3^n)
// Space: O(3^n)
