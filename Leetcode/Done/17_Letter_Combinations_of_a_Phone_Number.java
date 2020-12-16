// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
//
// A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
//
//
//
//
//
// Example 1:
//
// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// Example 2:
//
// Input: digits = ""
// Output: []
// Example 3:
//
// Input: digits = "2"
// Output: ["a","b","c"]
//
//
// Constraints:
//
// 0 <= digits.length <= 4
// digits[i] is a digit in the range ['2', '9'].




class Solution {
    Map<Character, String> map = initialize();
    List<String> combs = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits != null && !digits.isEmpty()){
            getCombs("", digits, 0);
        }
        return combs;
    }

    private Map<Character, String> initialize(){
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        return map;
    }

    private void getCombs(String current, String digits, int index){
        if(current.length() == digits.length()){
            combs.add(current);
            return;
        }
        for(int i = index; i < digits.length(); i++){
            String letters = map.get(digits.charAt(i));
            for(Character c : letters.toCharArray()){
                getCombs(current + c, digits, i + 1);
            }
        }
    }
}
// Time : O(3^N * 4^M)
// Space : O(3^N * 4^M)





class Solution {
    Map<Character, String> map = initialize();
    List<String> combs = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits != null && !digits.isEmpty()){
            getCombs("", digits, 0);
        }
        return combs;
    }

    private Map<Character, String> initialize(){
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        return map;
    }

    private void getCombs(String current, String digits, int index){
        if(current.length() == digits.length()){
            combs.add(current);
            return;
        }
        String letters = map.get(digits.charAt(index));
        for(Character c : letters.toCharArray()){
            getCombs(current + c, digits, index + 1);
        }
    }
}
// Time : O(3^N * 4^M)
// Space : O(3^N * 4^M)





class Solution {
    List<String> combs = new ArrayList<>();
    String[] keys = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        if(digits != null && !digits.isEmpty()){
            getCombs("", digits);
        }
        return combs;
    }

    private void getCombs(String current, String digits){
        if(digits.length() == 0){
            combs.add(current);
            return;
        }
        String letters = keys[(digits.charAt(0)) - '2' ];
        for(Character c : letters.toCharArray()){
            getCombs(current + c, digits.substring(1));
        }
    }
}
// Time : O(3^N * 4^M)
// Space : O(3^N * 4^M)
