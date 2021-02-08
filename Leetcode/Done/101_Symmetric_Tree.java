// Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
//
// For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
//
//     1
//    / \
//   2   2
//  / \ / \
// 3  4 4  3
//
//
// But the following [1,2,2,null,3,null,3] is not:
//
//     1
//    / \
//   2   2
//    \   \
//    3    3
//
//
// Follow up: Solve it both recursively and iteratively.





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
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null || left.val != right.val){
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
// Time : O(N)
// Space : O(N)






class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while(!queue.isEmpty()){
            TreeNode left = queue.remove();
            TreeNode right = queue.remove();
            if(left == null && right == null){
                continue;
            }
            if(left == null || right == null || left.val != right.val){
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }
}
// Time : O(N)
// Space : O(N)






class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while(!stack.isEmpty()){
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();
            if(left == null && right == null){
                continue;
            }
            if(left == null || right == null || left.val != right.val){
                return false;
            }
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }
        return true;
    }

}
// Time : O(N)
// Space : O(N)
