/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3


But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3
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
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        Stack<TreeNode> vals = new Stack<>();
        vals.push(root);
        vals.push(root);
        while(!vals.isEmpty()){
            TreeNode mirror1 = vals.pop();
            TreeNode mirror2 = vals.pop();
            if(mirror1 == null && mirror2 == null){
                continue;
            }
            if(mirror1 == null || mirror2 == null){
                return false;
            }
            if(mirror1.val != mirror2.val){
                return false;
            }
            vals.push(mirror1.left);
            vals.push(mirror2.right);
            vals.push(mirror1.right);
            vals.push(mirror2.left);
        }
        return true;
    }
}
