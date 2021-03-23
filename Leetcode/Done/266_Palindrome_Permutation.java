// Given a string, determine if a permutation of the string could form a palindrome.
//
// Example 1:
//
// Input: "code"
// Output: false
// Example 2:
//
// Input: "aab"
// Output: true
// Example 3:
//
// Input: "carerac"
// Output: true







class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] vals = new int[256];
        for(char c : s.toCharArray()){
            vals[c]++;
        }
        int sum = 0;
        for(int x : vals){
            sum += x%2;
        }
        return sum <= 1;

    }
}
// Time : O(N)
// Space : O(1)







class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int sum = 0;
        for (char key: map.keySet()) {
            sum += map.get(key) % 2;
        }
        return sum <= 1;

    }
}
// Time : O(N)
// Space : O(1)








class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int sum = 0;
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.get(c)%2==0){
                sum--;
            }else{
                sum++;
            }
        }

        return sum <= 1;

    }
}
// Time : O(N)
// Space : O(1)







class Solution {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for(Character c : s.toCharArray()){
            if(!set.add(c)){
                set.remove(c);
            }
        }
        return set.size() <= 1;

    }
}
// Time : O(N)
// Space : O(1)
