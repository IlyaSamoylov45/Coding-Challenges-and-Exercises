// Given the root node of a binary search tree, return the sum of values of all nodes with a value in the range [low, high].
//
//
//
// Example 1:
//
//
// Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
// Output: 32
// Example 2:
//
//
// Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
// Output: 23
//
//
// Constraints:
//
// The number of nodes in the tree is in the range [1, 2 * 104].
// 1 <= Node.val <= 105
// 1 <= low <= high <= 105
// All Node.val are unique.






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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null){
            return 0;
        }

        if(root.val < low){
            return rangeSumBST(root.right, low, high);
        }
        if(root.val > high){
            return rangeSumBST(root.left, low, high);
        }
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);


    }
}
// Time : O(N)
// Space : O(N)





class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null){
            return 0;
        }
        int sum = 0;
        if (low <= root.val && root.val <= high){
            sum += root.val;
        }
        if(low < root.val){
            sum += rangeSumBST(root.left, low, high);
        }
        if(root.val < high){
            sum += rangeSumBST(root.right, low, high);
        }
        return sum;

    }
}
// Time : O(N)
// Space : O(N)








class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null){
            return 0;
        }
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            if(low <= current.val && current.val <= high){
                sum += current.val;
            }
            if(current.left != null && low <= current.val){
                stack.push(current.left);
            }
            if(current.right != null && current.val <= high){
                stack.push(current.right);
            }
        }

        return sum;

    }
}
// Time : O(N)
// Space : O(N)









// Morris Traversal
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        TreeNode current = root;
        int sum = 0;
        while(current != null){
            if(current.left == null){
                if(low <= current.val && current.val <= high){
                    sum += current.val;
                }
                current = current.right;
            }else{
                TreeNode prev = current.left;
                while(prev.right != null && prev.right != current){
                    prev = prev.right;
                }
                if(prev.right == null){
                    if(low <= current.val && current.val <= high){
                        sum += current.val;
                    }
                    prev.right = current;
                    current = current.left;
                }else{
                    prev.right = null;
                    current = current.right;
                }
            }
        }
        return sum;

    }
}
// Time : O(N)
// Space : O(1)
