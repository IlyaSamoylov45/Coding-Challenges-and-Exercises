// Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
//
// Return the number of good nodes in the binary tree.
//
//
//
// Example 1:
//
//
//
// Input: root = [3,1,4,3,null,1,5]
// Output: 4
// Explanation: Nodes in blue are good.
// Root Node (3) is always a good node.
// Node 4 -> (3,4) is the maximum value in the path starting from the root.
// Node 5 -> (3,4,5) is the maximum value in the path
// Node 3 -> (3,1,3) is the maximum value in the path.
// Example 2:
//
//
//
// Input: root = [3,3,null,4,2]
// Output: 3
// Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.
// Example 3:
//
// Input: root = [1]
// Output: 1
// Explanation: Root is considered as good.
//
//
// Constraints:
//
// The number of nodes in the binary tree is in the range [1, 10^5].
// Each node's value is between [-10^4, 10^4].

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
    int count = 0;
    public int goodNodes(TreeNode root) {
        if(root == null){
            return count;
        }
        goodNodesSupport(root, root.val);
        return count;
    }

    private void goodNodesSupport(TreeNode root, int max){
        if(root == null){
            return;
        }
        if(root.val >= max){
            count++;
        }
        max = root.val > max ? root.val : max;
        goodNodesSupport(root.left, max);
        goodNodesSupport(root.right, max);
    }
}
// O(N) Time
// O(N) Space






class Solution {

    public int goodNodes(TreeNode root) {
        int count = 0;
        if(root == null){
            return count;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> values = new LinkedList<>();
        queue.offer(root);
        values.offer(root.val);
        while(!queue.isEmpty()){
            TreeNode curr = queue.remove();
            int max = values.remove();
            if(max <= curr.val){
                count++;
            }
            max = Math.max(curr.val, max);
            if(curr.left != null){
                queue.offer(curr.left);
                values.offer(max);
            }
            if(curr.right != null){
                queue.offer(curr.right);
                values.offer(max);
            }
        }
        return count;
    }
}
// O(N) Time
// O(N) Space
