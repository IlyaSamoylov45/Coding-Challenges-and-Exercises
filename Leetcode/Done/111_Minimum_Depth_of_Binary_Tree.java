// Given a binary tree, find its minimum depth.
//
// The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
//
// Note: A leaf is a node with no children.
//
//
//
// Example 1:
//
//
// Input: root = [3,9,20,null,null,15,7]
// Output: 2
// Example 2:
//
// Input: root = [2,null,3,null,4,null,5,null,6]
// Output: 5
//
//
// Constraints:
//
// The number of nodes in the tree is in the range [0, 105].
// -1000 <= Node.val <= 1000






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
    public int minDepth(TreeNode root) {
       if(root == null){
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0)  ? left + right + 1: Math.min(left,right) + 1;
    }

}
// Time : O(N)
// Space : O(N)








class Solution {
    public int minDepth(TreeNode root) {
        int level = 0;
        if(root != null){
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                level++;
                int size = queue.size();
                while(size-- > 0){
                    TreeNode current = queue.remove();
                    if(current.left == null && current.right == null){
                        return level;
                    }
                    if(current.left != null){
                        queue.offer(current.left);
                    }
                    if(current.right != null){
                        queue.offer(current.right);
                    }
                }
            }
        }
        return level;
    }

}
// Time : O(N)
// Space : O(N)








class Solution {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int lowest = Integer.MAX_VALUE;
        int level = 1;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> levels = new Stack<>();
        TreeNode current = root;
        while(!stack.isEmpty() || current != null){
            while(current != null){
                stack.push(current);
                current = current.left;
                levels.push(level++);
            }
            current = stack.pop();
            level = levels.pop();
            if(current.left == null && current.right == null){
                lowest = Math.min(lowest, level);
            }
            current = current.right;
            level++;
        }
        return lowest;
    }

}
// Time : O(N)
// Space : O(N)






class Solution {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int lowest = Integer.MAX_VALUE;
        int level = 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> levels = new Stack<>();
        TreeNode current = root;
        while(!stack.isEmpty() || current != null){
            while(current != null){
                stack.push(current);
                current = current.left;
                levels.push(++level);
            }
            current = stack.pop();
            level = levels.pop();
            if(current.left == null && current.right == null){
                lowest = Math.min(lowest, level);
            }
            current = current.right;
        }
        return lowest;
    }

}
// Time : O(N)
// Space : O(N)









class Solution {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int level = 0;
        int lowest = Integer.MAX_VALUE;
        TreeNode current = root;
        while(current != null){
            if(current.left == null){
                level++;
                if(current.right == null){
                    lowest = Math.min(level, lowest);
                }
                current = current.right;
            }else{
                TreeNode prev = current.left;
                int diff = 1;
                while(prev.right != null && prev.right != current){
                    prev = prev.right;
                    diff++;
                }
                if(prev.right == null){
                    level++;
                    prev.right = current;
                    current = current.left;
                }else{
                    if(prev.left == null){
                        lowest = Math.min(level, lowest);
                    }
                    level -= diff;
                    current = current.right;
                    prev.right = null;
                }
            }

        }
        return lowest;
    }

}
// Time : O(N)
// Space : O(1)
