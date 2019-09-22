/*
Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> vals = new ArrayList<String>();
        if (root != null){
            binaryTreePathsSupport(root, "", vals);
        }
        return vals;
    }
    public void binaryTreePathsSupport(TreeNode root, String s, List<String> vals){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            s += root.val;
            vals.add(s);
            return;
        }
        s += root.val + "->";
        binaryTreePathsSupport(root.left, s, vals);
        binaryTreePathsSupport(root.right, s, vals);
    }
}
