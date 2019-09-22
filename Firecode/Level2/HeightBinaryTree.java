/*
Given a binary tree, write a method to find its height recursively.
An empty tree has a height of 0.

Example:
     1
    / \
   2   3     ==> height=3
  / \ / \
 4  5 6  7
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public int findHeight(TreeNode root) {
    if(root == null){
        return 0;
    }
    return Math.max(findHeight(root.left), findHeight(root.right)) + 1;
}
