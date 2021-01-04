// Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
//
// Note: A leaf is a node with no children.
//
// Example:
//
// Given the below binary tree and sum = 22,
//
//       5
//      / \
//     4   8
//    /   / \
//   11  13  4
//  /  \    / \
// 7    2  5   1
// Return:
//
// [
//    [5,4,11,2],
//    [5,8,4,5]
// ]





/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> vals = new LinkedList<>();
        pathSum(root, sum, vals, new LinkedList<>());
        return vals;
    }

    private void pathSum(TreeNode root, int sum, List<List<Integer>> values, List<Integer> current){
        if(root == null){
            return;
        }
        sum -= root.val;
        current.add(root.val);
        if(root.left == null && root.right == null && sum == 0){
            values.add(new LinkedList<>(current));
        }
        pathSum(root.left, sum, values, current);
        pathSum(root.right, sum, values, current);
        current.remove(current.size() - 1);

    }
}
// Time : O(N)
// Space : O(N)








class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> vals = new LinkedList<>();
        List<Integer> path = new LinkedList<>();

        TreeNode curr = root;
        while(curr != null){
            if(curr.left == null){
                sum -= curr.val;
                path.add(curr.val);
                if(curr.right == null && sum == 0){
                    vals.add(new LinkedList<>(path));
                }
                curr = curr.right;
            }else{
                int size = 1;
                TreeNode prev = curr.left;
                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                    size++;
                }
                if(prev.right == null){
                    path.add(curr.val);
                    sum-=curr.val;
                    prev.right = curr;
                    curr = curr.left;
                }else{
                    if(prev.left == null && sum == 0){
                        vals.add(new LinkedList<>(path));
                    }
                    for(int i = 0; i < size; i++){
                        sum+=path.get(path.size() - 1);
                        path.remove(path.size() - 1);
                    }
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
        return vals;
    }
// Time : O(N)
// Space : O(1)
