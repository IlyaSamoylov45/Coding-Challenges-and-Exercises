// You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the graph.
//
// Return the number of connected components in the graph.
//
//
//
// Example 1:
//
//
// Input: n = 5, edges = [[0,1],[1,2],[3,4]]
// Output: 2
// Example 2:
//
//
// Input: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]
// Output: 1
//
//
// Constraints:
//
// 1 <= n <= 2000
// 1 <= edges.length <= 5000
// edges[i].length == 2
// 0 <= ai <= bi < n
// ai != bi
// There are no repeated edges.






class Solution {
    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        int count = 0;

        List<Integer>[] adjList = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adjList[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(adjList, visited, i);
            }
        }

        return count;
    }

    private void dfs(List<Integer>[] adjList, boolean[] visited, int startNode){
       visited[startNode] = true;

        for (int i = 0; i < adjList[startNode].size(); i++) {
            if (!visited[adjList[startNode].get(i)]) {
                dfs(adjList, visited, adjList[startNode].get(i));
            }
        }
    }
}
// Time : O( E + V )
// Space : O( E + V )
