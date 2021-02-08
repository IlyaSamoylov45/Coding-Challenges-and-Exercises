// Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1, and return them in any order.
//
// The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
//
//
//
// Example 1:
//
//
// Input: graph = [[1,2],[3],[3],[]]
// Output: [[0,1,3],[0,2,3]]
// Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
// Example 2:
//
//
// Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
// Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
// Example 3:
//
// Input: graph = [[1],[]]
// Output: [[0,1]]
// Example 4:
//
// Input: graph = [[1,2,3],[2],[3],[]]
// Output: [[0,1,2,3],[0,2,3],[0,3]]
// Example 5:
//
// Input: graph = [[1,3],[2],[3],[]]
// Output: [[0,1,2,3],[0,3]]
//
//
// Constraints:
//
// n == graph.length
// 2 <= n <= 15
// 0 <= graph[i][j] < n
// graph[i][j] != i (i.e., there will be no self-loops).
// The input graph is guaranteed to be a DAG.







class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        allPathsSourceTarget(graph, paths, path, 0);
        return paths;
    }

    private void allPathsSourceTarget(int[][] graph, List<List<Integer>> paths, List<Integer> path, int index){
        if(index == graph.length - 1){
            paths.add(new ArrayList<>(path));
            return;
        }
        for(int x : graph[index]){
            path.add(x);
            allPathsSourceTarget(graph, paths, path, x);
            path.remove(path.size() - 1);
        }
    }
}
// Time : O(2^n)
// Space : O(n)







class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while(!stack.isEmpty()){
            int index = stack.peek();
            if(path.size() > 0 && index == path.get(path.size() - 1)){
                stack.pop();
                path.remove(path.size() - 1);
                continue;
            }
            path.add(index);
            if(index == graph.length - 1){
                paths.add(new ArrayList<>(path));
            }else{
                for(int x : graph[index]){
                    stack.push(x);
                }
            }
        }
        return paths;
    }

}
// Time : O(2^n)
// Space : O(n)
