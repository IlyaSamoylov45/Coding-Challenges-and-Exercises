/**
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
**/

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> vals = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        combine(vals, curr, 1, n, k);
        return vals;
    }

    public void combine(List<List<Integer>> vals, List<Integer> curr, int index, int n, int k){
        if(curr.size() == k){
            vals.add(new ArrayList<>(curr));
            return;
        }
        if(curr.size() > k){
            return;
        }
        for(int i = index; i <= n; i++){
            curr.add(i);
            combine(vals, curr, i + 1, n, k);
            curr.remove(curr.size() - 1);
        }
    }
}
