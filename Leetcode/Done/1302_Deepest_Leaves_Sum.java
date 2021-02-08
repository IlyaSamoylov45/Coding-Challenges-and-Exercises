// Given a binary tree, return the sum of values of its deepest leaves.
//
//
// Example 1:
//
//
//
// Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
// Output: 15
//
//
// Constraints:
//
// The number of nodes in the tree is between 1 and 10^4.
// The value of nodes is between 1 and 100.






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
    int maxDepth = 0;
    int max = 0;

    public int deepestLeavesSum(TreeNode root) {
        deepest(root, 0);
        return max;
    }

    private void deepest(TreeNode root, int depth){
        if(root == null){
            return;
        }
        if(depth > maxDepth){
            max = root.val;
            maxDepth = depth;
        }else if(depth == maxDepth){
            max += root.val;
        }
        deepest(root.left, depth + 1);
        deepest(root.right, depth + 1);
    }
}
// Time : O(N)
// Space : O(N)







class Solution {
    public int deepestLeavesSum(TreeNode root) {
        int max = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            max = 0;
            int size = queue.size();
            while(size-- > 0){
                TreeNode curr = queue.remove();
                max += curr.val;
                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }
        }
        return max;
    }
}
// Time : O(N)
// Space : O(N)






class Solution {

    public int deepestLeavesSum(TreeNode root) {
        TreeNode curr = root;
        int max = 0;
        int depth = 0;
        int maxDepth = 0;
        while(curr != null){
            if(curr.left == null){
                if(depth > maxDepth){
                    max = curr.val;
                    maxDepth = depth;
                }else if(depth == maxDepth){
                    max += curr.val;
                }
                depth++;
                curr = curr.right;
            }else{
                TreeNode prev = curr.left;
                int depthDiff = 1;
                while(prev.right != null && prev.right != curr){
                    depthDiff++;
                    prev = prev.right;
                }
                if(prev.right == null){
                    if(depth > maxDepth){
                        max = curr.val;
                        maxDepth = depth;
                    }else if(depth == maxDepth){
                        max += curr.val;
                    }
                    prev.right = curr;
                    curr = curr.left;
                    depth++;
                }else{
                    depth -= depthDiff;
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
        return max;
    }

}
// Time : O(N)
// Space : O(1)
