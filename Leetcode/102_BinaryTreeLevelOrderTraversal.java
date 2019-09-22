/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> vals = new LinkedList<>();
        Queue<TreeNode> level = new LinkedList<>();
        if(root == null){
            return vals;
        }
        level.offer(root);
        while(!level.isEmpty()){
            List<Integer> currLevel = new LinkedList<>();
            int size = level.size();
            while(size > 0){
                TreeNode curr = level.remove();
                if(curr.left != null){
                    level.offer(curr.left);
                }
                if(curr.right != null){
                    level.offer(curr.right);
                }
                currLevel.add(curr.val);
                size--;
            }
            vals.add(currLevel);
        }
        return vals;
    }
}
