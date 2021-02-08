// Given the root of a binary tree, return the inorder traversal of its nodes' values.
//
//
//
// Example 1:
//
//
// Input: root = [1,null,2,3]
// Output: [1,3,2]
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
// Output: [2,1]
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
// Follow up:
//
// Recursive solution is trivial, could you do it iteratively?





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
    List<Integer> values = new LinkedList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return values;
        }
        inorderTraversal(root.left);
        values.add(root.val);
        inorderTraversal(root.right);
        return values;
    }
}
// Time : O(N)
// Space : O(N)






class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> values = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while(!stack.isEmpty() || current != null){
            while(current != null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            values.add(current.val);
            current = current.right;
        }
        return values;
    }
}
// Time : O(N)
// Space : O(N)






class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> values = new LinkedList<>();
        TreeNode current = root;
        while(current != null){
            if(current.left == null){
                values.add(current.val);
                current = current.right;
            }else{
                TreeNode prev = current.left;
                while(prev.right != null && prev.right != current){
                    prev = prev.right;
                }
                if(prev.right == null){
                    prev.right = current;
                    current = current.left;
                }else{
                    prev.right = null;
                    values.add(current.val);
                    current = current.right;
                }
            }
        }

        return values;
    }
}
// Time : O(N)
// Space : O(1)
