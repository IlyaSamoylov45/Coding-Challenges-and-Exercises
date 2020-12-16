// Given a binary tree, return all root-to-leaf paths.
//
// Note: A leaf is a node with no children.
//
// Example:
//
// Input:
//
//    1
//  /   \
// 2     3
//  \
//   5
//
// Output: ["1->2->5", "1->3"]
//
// Explanation: All root-to-leaf paths are: 1->2->5, 1->3



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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        binaryTreePaths(root, "", paths);
        return paths;
    }

    private void binaryTreePaths(TreeNode root, String s, List<String> paths){
        if(root == null){
            return;
        }
        if(!s.equals("")){
            s = s + "->";
        }
        s += root.val;
        if(root.left == null && root.right == null){
            paths.add(s);
            return;
        }
        binaryTreePaths(root.left, s, paths);
        binaryTreePaths(root.right, s, paths);
    }
}
// Time : O(N)
// Space : O(N)





class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        binaryTreePaths(root, "", paths);
        return paths;
    }

    private void binaryTreePaths(TreeNode root, String s, List<String> paths){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            s += root.val;
            paths.add(s);
            return;
        }
        s += root.val + "->";
        binaryTreePaths(root.left, s, paths);
        binaryTreePaths(root.right, s, paths);
    }
}
// Time : O(N)
// Space : O(N)
