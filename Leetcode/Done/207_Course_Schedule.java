// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
//
// For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
// Return true if you can finish all courses. Otherwise, return false.
//
//
//
// Example 1:
//
// Input: numCourses = 2, prerequisites = [[1,0]]
// Output: true
// Explanation: There are a total of 2 courses to take.
// To take course 1 you should have finished course 0. So it is possible.
// Example 2:
//
// Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
// Output: false
// Explanation: There are a total of 2 courses to take.
// To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
//
//
// Constraints:
//
// 1 <= numCourses <= 105
// 0 <= prerequisites.length <= 5000
// prerequisites[i].length == 2
// 0 <= ai, bi < numCourses
// All the pairs prerequisites[i] are unique.





class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> courseDict = new HashMap<>();
        int[] indegree = new int[numCourses];

        for(int[] relation : prerequisites){
            indegree[relation[0]]++;
            if(courseDict.containsKey(relation[1])){
                courseDict.get(relation[1]).add(relation[0]);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(relation[0]);
                courseDict.put(relation[1], list);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        int count = 0;

        while(!queue.isEmpty()){
            int curr = queue.poll();
            if(indegree[curr] == 0){
                count++;
            }
            if(!courseDict.containsKey(curr)){
                continue;
            }
            for(int neighbor : courseDict.get(curr)){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }



        return count == numCourses;
    }
}
// Time : O( |E| + |V|)
// Space : O(|E| + |V|)
