// Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
//
// You may return the answer in any order.
//
//
//
// Example 1:
//
// Input: n = 4, k = 2
// Output:
// [
//   [2,4],
//   [3,4],
//   [2,3],
//   [1,2],
//   [1,3],
//   [1,4],
// ]
// Example 2:
//
// Input: n = 1, k = 1
// Output: [[1]]
//
//
// Constraints:
//
// 1 <= n <= 20
// 1 <= k <= n


// Backtracking Solution
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> values = new ArrayList<>();
        combine(n,k,new ArrayList<>(),values,1);
        return values;
    }

    private void combine(int n, int k, List<Integer> curr, List<List<Integer>> values, int index){
        if(curr.size() == k){
            values.add(new ArrayList<>(curr));
            return;
        }
        for(int i = index; i <= n; i++){
            curr.add(i);
            combine(n,k,curr,values,i+1);
            curr.remove(curr.size()-1);
        }
    }
}

//Time : O(kC(N choose k))
//Space : O(kC(N choose k))


//Slightly faster with LinkedList removeLast
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<List<Integer>> values = new LinkedList<>();
        combine(n,k,new LinkedList<>(),values,1);
        return values;
    }

    private void combine(int n, int k, LinkedList<Integer> curr, LinkedList<List<Integer>> values, int index){
        if(curr.size() == k){
            values.add(new LinkedList<>(curr));
            return;
        }
        for(int i = index; i <= n; i++){
            curr.add(i);
            combine(n,k,curr,values,i+1);
            curr.removeLast();
        }
    }
}
//Time : O(kC(N choose k))
//Space : O(kC(N choose k))


//Slightly faster no recursion
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> values = new LinkedList<>();
        List<Integer> current = new LinkedList<>();
        for(int i = 1; i <= k; i++){
            current.add(i);
        }
        current.add(n+1);
        int j = 0;
        while(j < k){
            values.add(new LinkedList<>(current).subList(0, k));
            j = 0;
            while((j < k) && (current.get(j + 1) == current.get(j) + 1)){
                current.set(j, j + 1);
                j++;
            }
            current.set(j, current.get(j) + 1);

        }
        return values;
    }
}
//Time : O(kC(N choose k))
//Space : O(C(N choose k))
