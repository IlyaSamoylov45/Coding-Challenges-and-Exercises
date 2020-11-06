// Find the sum of all left leaves in a given binary tree.
//
// Example:
//
//     3
//    / \
//   9  20
//     /  \
//    15   7
//
// There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.



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
    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return sum;
        }
        if(root.left != null && root.left.left == null && root.left.right == null){
            sum += root.left.val;
        }
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return sum;
    }
}
// Time: O(N)
// Space: O(N)






class Solution{
    public int sumOfLeftLeaves(TreeNode root){
        return sumOfLeftLeavesSupport(root, false);
    }

    public int sumOfLeftLeavesSupport(TreeNode root, boolean isLeftLeaf){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return isLeftLeaf ? root.val : 0;
        }
        return sumOfLeftLeavesSupport(root.left, true) + sumOfLeftLeavesSupport(root.right, false);
    }
}
// Time: O(N)
// Space: O(N)





class Solution{
    private boolean isLeaf(TreeNode node){
        return node != null && node.left == null && node.right == null;
    }

    public int sumOfLeftLeaves(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        if(root != null){
            stack.push(root);
        }
        int sum = 0;
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();

            if(isLeaf(curr.left)){
                sum += curr.left.val;
            }

            if(curr.left != null){
                stack.push(curr.left);
            }
            if(curr.right != null){
                stack.push(curr.right);
            }
        }
        return sum;
    }
}
// Time: O(N)
// Space: O(N)





class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        TreeNode curr = root;
        while(curr!= null){
            if(curr.left == null){
                curr = curr.right;
            }else{
                TreeNode prev = curr.left;
                if(prev.left == null && prev.right == null){
                    sum += prev.val;
                }
                while(prev.right != null && prev.right != curr){
                    prev=prev.right;
                }
                if(prev.right == null){
                    prev.right = curr;
                    curr = curr.left;
                }else{
                    prev.right  = null;
                    curr = curr.right;

                }

            }
        }
        return sum;
    }
}
//// Time: O(N)
//// Space: O(1)
