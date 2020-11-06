// Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
//
// Note: A leaf is a node with no children.
//
// Example:
//
// Given the below binary tree and sum = 22,
//
//       5
//      / \
//     4   8
//    /   / \
//   11  13  4
//  /  \      \
// 7    2      1
// return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.



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

 // Recursive
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        sum -= root.val;
        if(root.left == null && root.right == null){
            return sum == 0;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
// Time ; O(N)
// Space : O(N)





//Iterative
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair(root, sum));
        while(!queue.isEmpty()){
            Pair<TreeNode, Integer> curr = queue.remove();
            TreeNode currNode = curr.getKey();
            int value = curr.getValue() - currNode.val;
            if(currNode.left == null && currNode.right == null){
                if(value == 0){
                    return true;
                }
                continue;
            }
            if(currNode.left != null){
                queue.offer(new Pair(currNode.left, value));
            }
            if(currNode.right != null){
                queue.offer(new Pair(currNode.right, value));
            }
        }
        return false;
    }
}
// Time ; O(N)
// Space : O(N)
