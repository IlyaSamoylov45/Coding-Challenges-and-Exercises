// Given the root of a binary tree, determine if it is a valid binary search tree (BST).
//
// A valid BST is defined as follows:
//
// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.
//
//
// Example 1:
//
//
// Input: root = [2,1,3]
// Output: true
// Example 2:
//
//
// Input: root = [5,1,4,null,null,3,6]
// Output: false
// Explanation: The root node's value is 5 but its right child's value is 4.
//
//
// Constraints:
//
// The number of nodes in the tree is in the range [1, 104].
// -2^31 <= Node.val <= 2^31 - 1






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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer min, Integer max){
        if(root == null){
            return true;
        }
        if((min != null && root.val <= min) || (max!= null && root.val >= max)){
            return false;
        }
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }


}
// Time : O(N)
// Space : O(N)







class Solution {
    Queue<TreeNode> values = new LinkedList<>();
    Queue<Integer> lows = new LinkedList<>();
    Queue<Integer> highs = new LinkedList<>();

    public boolean isValidBST(TreeNode root) {
        update(root, null, null);
        while(!values.isEmpty()){
            TreeNode current = values.remove();
            Integer low = lows.remove();
            Integer high = highs.remove();
            if(current == null){
                continue;
            }
            if(low != null && current.val <= low){
                return false;
            }
            if(high != null && current.val >= high){
                return false;
            }
            update(current.left, low, current.val);
            update(current.right, current.val, high);

        }
        return true;

    }

    private void update(TreeNode root, Integer low, Integer high){
        values.offer(root);
        lows.offer(low);
        highs.offer(high);
    }

}
// Time : O(N)
// Space : O(N)







class Solution {
    private Integer prev = null;

    public boolean isValidBST(TreeNode root) {
       return inOrder(root);
    }

    private boolean inOrder(TreeNode root){
        if(root == null){
            return true;
        }
        if(!inOrder(root.left)){
            return false;
        }
        if(prev != null && root.val <= prev){
            return false;
        }
        prev = root.val;
        return inOrder(root.right);
    }

}
// Time : O(N)
// Space : O(N)








class Solution {

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Integer prev = null;
        TreeNode current = root;
        while(!stack.isEmpty() || current != null){
            while(current != null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if(prev != null && current.val <= prev){
                return false;
            }
            prev = current.val;
            current = current.right;
        }
        return true;
    }
}
// Time : O(N)
// Space : O(N)







class Solution {

    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }
        TreeNode curr = root;
        Integer prev = null;
        while(curr != null){
            if(curr.left == null){
                if(prev != null && prev >= curr.val){
                    return false;
                }
                prev = curr.val;
                curr = curr.right;
            }else{
                TreeNode next = curr.left;
                while(next.right != null && next.right != curr){
                    next = next.right;
                }
                if(next.right != null){
                    if(prev != null && prev >= curr.val){
                        return false;
                    }
                    next.right = null;
                    prev = curr.val;
                    curr = curr.right;
                }else{
                    next.right = curr;
                    curr = curr.left;
                }
            }
        }
        return true;
    }

}
// Time : O(N)
// Space : O(1)
