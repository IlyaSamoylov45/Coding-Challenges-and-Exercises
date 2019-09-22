/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> vals = new LinkedList<>();
        List<Integer> curr = new LinkedList<>();
        pathSumSupport(root, sum, vals, curr);
        return vals;
    }

    public void pathSumSupport(TreeNode root, int sum, List<List<Integer>> vals, List<Integer> curr){
        if(root == null){
            return;
        }
        curr.add(root.val);
        if(root.left == null && root.right == null && sum - root.val == 0){
            vals.add(new LinkedList<>(curr));
        }
        pathSumSupport(root.left, sum-root.val, vals, curr);
        pathSumSupport(root.right, sum-root.val, vals, curr);
        curr.remove(curr.size()-1);
    }

}
