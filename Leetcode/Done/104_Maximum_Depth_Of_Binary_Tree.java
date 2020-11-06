// Given a binary tree, find its maximum depth.
//
// The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
//
// Note: A leaf is a node with no children.
//
// Example:
//
// Given binary tree [3,9,20,null,null,15,7],
//
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its depth = 3.




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

 //Recursive
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

// Time : O(N)
// Space : O(N)


// Morris Traversal
class Solution {
    public int maxDepth(TreeNode root) {
        TreeNode prev = null;
        TreeNode current = root;
        int maxSum = 0;
        int currLevel = 0;
        while(current != null){
            if(current.left == null){
                currLevel++;
                current = current.right;
            }else{
                int deltaDepth = 1;
                prev = current.left;
                while(prev.right != null && prev.right != current){
                    prev = prev.right;
                    deltaDepth++;
                }
                if(prev.right == null){
                    prev.right = current;
                    current = current.left;
                    currLevel++;
                }else{
                    prev.right = null;
                    current = current.right;
                    currLevel -= deltaDepth;
                }
            }
            maxSum = Math.max(maxSum, currLevel);
        }
        return maxSum;
    }
}

// O(N) Time
// O(1) Space



class Solution {
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        TreeNode curr = root;
        int currDepth = 0;
        TreeNode prev = null;
        int foundDepth = -1;
        while(curr != null){
            if(curr.left == null){
                currDepth++;
                if(curr == u){
                    foundDepth = currDepth;
                }else if(foundDepth == currDepth){
                    return curr;
                }
                curr = curr.right;
            }else{
                int deltaDepth = 1;
                prev = curr.left;
                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                    deltaDepth++;
                }
                if(prev.right == null){
                    currDepth++;
                    if(curr == u){
                        foundDepth = currDepth;
                    }else if(foundDepth == currDepth){
                        return curr;
                    }
                    prev.right = curr;
                    curr = curr.left;
                }else{
                    prev.right = null;
                    curr = curr.right;
                    currDepth -= deltaDepth;
                }
            }
        }
        return null;
    }
}
// Time : O(N)
// Space : O(1)
