/*
Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null){
            return ret;
        }
        TreeNode prev = null;
        while(root != null){
            if(root.left == null){
                ret.add(root.val);
                root = root.right;
            }else{
                prev = root.left;
                while(prev.right != null && prev.right != root){
                    prev = prev.right;
                }
                if(prev.right == null){
                    prev.right = root;
                    root = root.left;
                }else{
                    prev.right = null;
                    ret.add(root.val);
                    root = root.right;
                }
            }
        }
        return ret;
    }
}
