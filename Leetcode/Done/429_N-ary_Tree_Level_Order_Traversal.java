// Given an n-ary tree, return the level order traversal of its nodes' values.
//
// Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
//
//
//
// Example 1:
//
//
//
// Input: root = [1,null,3,2,4,null,5,6]
// Output: [[1],[3,2,4],[5,6]]
// Example 2:
//
//
//
// Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
// Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
//
//
// Constraints:
//
// The height of the n-ary tree is less than or equal to 1000
// The total number of nodes is between [0, 10^4]




/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> values = new LinkedList<>();
        if(root == null){
            return values;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new LinkedList<>();
            while(size-- > 0){
                Node current = queue.remove();
                level.add(current.val);
                queue.addAll(current.children);
            }
            values.add(level);

        }
        return values;
    }
}
// Time : O(N)
// Space : O(N)





class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(Node root, int depth, List<List<Integer>> result){
        if(root != null){
            if(result.size() < depth + 1){
                result.add(new ArrayList<Integer>());
            }
            result.get(depth).add(root.val);
            for(Node child : root.children){
                dfs(child, depth+1, result);
            }
        }
    }
}
// Time : O(N)
// Space : O(N)
