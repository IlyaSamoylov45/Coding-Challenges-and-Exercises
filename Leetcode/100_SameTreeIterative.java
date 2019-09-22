/*
Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true
Example 2:

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false
Example 3:

Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        Stack<TreeNode> pNodes = new Stack<>();
        Stack<TreeNode> qNodes = new Stack<>();
        pNodes.push(p);
        qNodes.push(q);
        while(!pNodes.isEmpty() && !qNodes.isEmpty()){
            if(pNodes.peek().val != qNodes.peek().val){
                return false;
            }
            TreeNode curr = pNodes.pop();
            TreeNode curr2 = qNodes.pop();
            if(curr.left != null){
                pNodes.push(curr.left);
            }
            if(curr2.left != null){
                qNodes.push(curr2.left);
            }
            if(pNodes.size() != qNodes.size()){
                return false;
            }
            if(curr.right != null){
                pNodes.push(curr.right);
            }
            if(curr2.right != null){
                qNodes.push(curr2.right);
            }
            if(pNodes.size() != qNodes.size()){
                return false;
            }

        }
        return pNodes.isEmpty() && qNodes.isEmpty();

    }
}
