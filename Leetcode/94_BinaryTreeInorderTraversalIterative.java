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
        Stack<TreeNode> vals = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !vals.isEmpty()){
            while(curr != null){
                vals.push(curr);
                curr = curr.left;
            }
            curr = vals.pop();
            ret.add(curr.val);
            curr = curr.right;
        }
        return ret;
    }
}
