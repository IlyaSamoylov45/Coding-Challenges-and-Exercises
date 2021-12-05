// Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only one right child.
//
//
//
// Example 1:
//
//
// Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
// Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
// Example 2:
//
//
// Input: root = [5,1,7]
// Output: [1,null,5,null,7]
//
//
// Constraints:
//
// The number of nodes in the given tree will be in the range [1, 100].
// 0 <= Node.val <= 1000





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
    TreeNode curr;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        curr = ans;
        inOrder(root);
        return ans.right;
    }

    private void inOrder(TreeNode node){
        if (node == null){
            return;
        }
        inOrder(node.left);
        node.left = null;
        curr.right = node;
        curr = curr.right;
        inOrder(node.right);

    }
}
// Time : O(N)
// Space : O(N)





class Solution {
    TreeNode curr;

    public TreeNode increasingBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode ans = new TreeNode(0);
        curr = ans;

        while(!stack.isEmpty() || root != null){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root.left = null;
            curr.right = root;
            curr = curr.right;
            root = root.right;
        }

        return ans.right;
    }
}
// Time : O(N)
// Space : O(N)




class Solution {

    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans = null;
        TreeNode curr = null;

        while(root != null){
            if(root.left == null){
                if(ans == null){
                    ans = root;
                }
                curr = root;
                root = root.right;
            }else{
                TreeNode prev = root.left;
                while(prev != null && prev.right != null){
                    prev = prev.right;
                }
                prev.right = root;
                TreeNode temp = root;
                root = root.left;
                if(curr != null){
                    curr.right = root;
                }
                temp.left = null;

            }
        }

        return ans;
    }

}
// Time : O(N)
// Space : O(1)
