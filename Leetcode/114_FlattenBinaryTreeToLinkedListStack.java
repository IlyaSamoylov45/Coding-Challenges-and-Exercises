/*
Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
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
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        Stack<TreeNode> vals = new Stack<>();
        vals.push(root);
        while(!vals.isEmpty()){
            TreeNode curr = vals.pop();
            if(curr.right != null){
                vals.push(curr.right);
            }
            if(curr.left != null){
                vals.push(curr.left);
            }
            if(!vals.isEmpty()){
                curr.right = vals.peek();
            }
            curr.left = null;
        }
    }
}
