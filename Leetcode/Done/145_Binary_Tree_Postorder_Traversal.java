// Given the root of a binary tree, return the postorder traversal of its nodes' values.
//
//
//
// Example 1:
//
//
// Input: root = [1,null,2,3]
// Output: [3,2,1]
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
// Output: [2,1]
//
//
// Constraints:
//
// The number of the nodes in the tree is in the range [0, 100].
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
    List<Integer> vals = new LinkedList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null){
            return vals;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        vals.add(root.val);
        return vals;
    }
}
// Time : O(N)
// Space : O(N)








// Incorrect Solution
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> vals = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            if(current == null){
                continue;
            }
            vals.addFirst(current.val);
            stack.push(current.left);
            stack.push(current.right);

        }
        return vals;
    }
}
// Time : O(N)
// Space : O(N)








class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> vals = new LinkedList<>();
        if(root == null){
            return vals;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode current = stack.peek();
            if(prev == null || prev.left == current || prev.right == current){
                if(current.left != null){
                    stack.push(current.left);
                }else if(current.right != null){
                    stack.push(current.right);
                }else{
                    stack.pop();
                    vals.add(current.val);
                }
            }else if(current.left == prev){
                if (current.right != null){
                    stack.push(current.right);
                }else{
                    stack.pop();
                    vals.add(current.val);
                }
            }else if(current.right == prev){
                stack.pop();
                vals.add(current.val);
            }
            prev = current;

        }
        return vals;
    }
}
// Time : O(N)
// Space : O(N)







class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> vals = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null){
            return vals;
        }
        stack.add(root);
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            if(!stack.isEmpty() && current == stack.peek()){
                if(current.right != null){
                    stack.push(current.right);
                    stack.push(current.right);
                }
                if(current.left != null){
                    stack.push(current.left);
                    stack.push(current.left);
                }
            }else{
                vals.add(current.val);
            }
        }
        return vals;
    }
}
// Time : O(N)
// Space : O(N)








class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> vals = new LinkedList<>();
        TreeNode current = root;
        while(current != null){
            if(current.right == null){
                vals.addFirst(current.val);
                current = current.left;
            }else{
                TreeNode prev = current.right;
                while(prev.left != null && prev.left != current){
                    prev = prev.left;
                }
                if(prev.left == null){
                    prev.left = current;
                    vals.addFirst(current.val);
                    current = current.right;
                }else{
                    prev.left = null;
                    current = current.left;
                }
            }
        }
        return vals;
    }
}
// Time : O(N)
// Space : O(1)
