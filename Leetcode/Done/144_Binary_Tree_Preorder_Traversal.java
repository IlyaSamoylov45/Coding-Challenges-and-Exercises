// Given the root of a binary tree, return the preorder traversal of its nodes' values.
//
//
//
// Example 1:
//
//
// Input: root = [1,null,2,3]
// Output: [1,2,3]
// Example 2:
//
// Input: root = []
// Output: []
// Example 3:
//
// Input: root = [1]
// Output: [1]
// Example 4:
//
//
// Input: root = [1,2]
// Output: [1,2]
// Example 5:
//
//
// Input: root = [1,null,2]
// Output: [1,2]
//
//
// Constraints:
//
// The number of nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 100
//
//
// Follow up: Recursive solution is trivial, could you do it iteratively?





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
    List<Integer> vals = new LinkedList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            return vals;
        }
        vals.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return vals;
    }
}
// Time : O(N)
// Space : O(N)







class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> vals = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root != null){
            stack.push(root);
        }
        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            vals.add(current.val);
            if(current.right != null){
                stack.push(current.right);
            }
            if(current.left != null){
                stack.push(current.left);
            }
        }
        return vals;
    }
}
// Time : O(N)
// Space : O(N)








class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> vals = new LinkedList<>();
        TreeNode current = root;
        while(current != null){
            if(current.left == null){
                vals.add(current.val);
                current = current.right;
            }else{
                TreeNode prev = current.left;
                while(prev.right != null && prev.right != current){
                    prev = prev.right;
                }
                if(prev.right == null){
                    prev.right = current;
                    vals.add(current.val);
                    current = current.left;
                }else{
                    prev.right = null;
                    current = current.right;
                }
            }
        }
        return vals;
    }
}
// Time : O(N)
// Space : O(1)
