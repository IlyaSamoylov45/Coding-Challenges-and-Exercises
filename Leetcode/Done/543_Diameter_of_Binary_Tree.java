// Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
//
// Example:
// Given a binary tree
//           1
//          / \
//         2   3
//        / \
//       4   5
// Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
//
// Note: The length of path between two nodes is represented by the number of edges between them.










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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    private int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
// Time : O(N)
// Space : O(N)









class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int max = 0;
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode,Integer> map = new HashMap<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curr = stack.peek();
            if(curr.left != null && !map.containsKey(curr.left)){
                stack.push(curr.left);
            }else if(curr.right!=null && !map.containsKey(curr.right)){
                stack.push(curr.right);
            }else{
                stack.pop();
                int leftMax = map.getOrDefault(curr.left, 0);
                int rightMax = map.getOrDefault(curr.right, 0);
                int currMax = 1 + Math.max(leftMax, rightMax);
                map.put(curr, currMax);
                max = Math.max(max, leftMax + rightMax);
            }

        }
        return max;
    }
}
// Time : O(N)
// Space : O(N)
