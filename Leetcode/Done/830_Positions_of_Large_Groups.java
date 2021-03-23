// In a string s of lowercase letters, these letters form consecutive groups of the same character.
//
// For example, a string like s = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z", and "yy".
//
// A group is identified by an interval [start, end], where start and end denote the start and end indices (inclusive) of the group. In the above example, "xxxx" has the interval [3,6].
//
// A group is considered large if it has 3 or more characters.
//
// Return the intervals of every large group sorted in increasing order by start index.
//
//
//
// Example 1:
//
// Input: s = "abbxxxxzzy"
// Output: [[3,6]]
// Explanation: "xxxx" is the only large group with start index 3 and end index 6.
// Example 2:
//
// Input: s = "abc"
// Output: []
// Explanation: We have groups "a", "b", and "c", none of which are large groups.
// Example 3:
//
// Input: s = "abcdddeeeeaabbbcd"
// Output: [[3,5],[6,9],[12,14]]
// Explanation: The large groups are "ddd", "eeee", and "bbb".
// Example 4:
//
// Input: s = "aba"
// Output: []
//
//
// Constraints:
//
// 1 <= s.length <= 1000
// s contains lower-case English letters only.







class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> arr = new ArrayList<>();
        char prev = s.charAt(0);
        int i = 0, count = 0;
        for(; i < s.length(); i++){
            char curr = s.charAt(i);
            if(prev != curr){
                if(count >= 3){
                    arr.add(Arrays.asList(new Integer[]{i - count, i - 1}));
                }
                count = 0;
                prev = curr;
            }
            count++;
        }
        if(count >= 3){
            arr.add(Arrays.asList(new Integer[]{i - count, i - 1}));
        }
        return arr;
    }
}
// Time : O(N)
// Space : O(N)








class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ans = new ArrayList();
        int i = 0, N = S.length();
        for (int j = 0; j < N; ++j) {
            if (j == N-1 || S.charAt(j) != S.charAt(j+1)) {
                if (j-i+1 >= 3)
                    ans.add(Arrays.asList(new Integer[]{i, j}));
                i = j + 1;
            }
        }

        return ans;
    }
}
// Time : O(N)
// Space : O(N)
