// A binary tree is univalued if every node in the tree has the same value.
//
// Return true if and only if the given tree is univalued.
//
//
//
// Example 1:
//
//
// Input: [1,1,1,1,1,null,1]
// Output: true
// Example 2:
//
//
// Input: [2,2,2,5,2]
// Output: false
//
//
// Note:
//
// The number of nodes in the given tree will be in the range [1, 100].
// Each node's value will be an integer in the range [0, 99].





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
    public boolean isUnivalTree(TreeNode root) {
        if(root == null){
            return true;
        }
        if(root.left != null && root.left.val != root.val){
            return false;
        }
        if(root.right != null && root.right.val != root.val){
            return false;
        }
        return isUnivalTree(root.left) && isUnivalTree(root.right);

    }
}
// Time : O(N)
// Space : O(N)





class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if(root == null){
            return true;
        }
        return isUnivalTree(root, root.val);

    }

    private boolean isUnivalTree(TreeNode root, int val){
        if(root == null){
            return true;
        }
        if(root.val != val){
            return false;
        }
        return isUnivalTree(root.left, val) && isUnivalTree(root.right, val);

    }
}
// Time : O(N)
// Space : O(N)








class Solution {
    public boolean isUnivalTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        int val = root.val;
        TreeNode current = root;
        while(!stack.isEmpty() || current != null){
            while(current != null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if(current.val != val){
                return false;
            }
            current = current.right;
        }
        return true;
    }
}
// Time : O(N)
// Space : O(N)





class Solution {
    public boolean isUnivalTree(TreeNode root) {
        TreeNode current = root;
        int val = root.val;
        while(current != null){
            if(current.left == null){
                if(current.val != val){
                    return false;
                }
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
                    if(current.val != val){
                        return false;
                    }
                    prev.right = null;
                    current = current.right;
                }
            }
        }
        return true;
    }
}
// Time : O(N)
// Space : O(1)
