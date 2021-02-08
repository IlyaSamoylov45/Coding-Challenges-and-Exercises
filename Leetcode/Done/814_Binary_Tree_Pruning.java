// We are given the head node root of a binary tree, where additionally every node's value is either a 0 or a 1.
//
// Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
//
// (Recall that the subtree of a node X is X, plus every node that is a descendant of X.)
//
// Example 1:
// Input: [1,null,0,0,1]
// Output: [1,null,0,null,1]
//
// Explanation:
// Only the red nodes satisfy the property "every subtree not containing a 1".
// The diagram on the right represents the answer.
//
//
// Example 2:
// Input: [1,0,1,0,0,0,1]
// Output: [1,null,1,null,1]
//
//
//
// Example 3:
// Input: [1,1,0,1,1,0,1,0]
// Output: [1,1,0,1,1,null,1]
//
//
//
// Note:
//
// The binary tree will have at most 200 nodes.
// The value of each node will only be 0 or 1.






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
    public TreeNode pruneTree(TreeNode root) {
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
            return root.val == 1 ? root : null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        return root.left == null && root.right == null && root.val == 0 ? null : root;

    }
}
// Time : O(N)
// Space : O(N)






class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null){
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        return root.left == null && root.right == null && root.val == 0 ? null : root;

    }
}
// Time : O(N)
// Space : O(N)






class Solution {
    public TreeNode pruneTree(TreeNode root) {
        TreeNode curr = root, prev = null;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || curr != null){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.peek();
            if (curr.right == null || curr.right == prev) {
                stack.pop();
                if (!stack.isEmpty()) {
                    if (curr.val == 0 && curr.left == null && curr.right == null) {
                        TreeNode node = stack.peek();
                        if(node.left == curr){
                            node.left = null;
                        }else{
                            node.right = null;
                        }
                    }
                }
                prev = curr;
                curr = null;
            }else{
                curr = curr.right;
            }
        }
        return root.left == null && root.right == null && root.val == 0 ? null : root;
    }
}
// Time : O(N)
// Space : O(N)
