/*
Given a binary tree, write a method to return its size. The size of a tree is the number of nodes it contains.
Examples:
     1
    / \
   2   3     ==>  7
  / \ / \
 4  5 6  7
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public int size(TreeNode root) {
    if(root == null){
        return 0;
    }
    return size(root.left) + size(root.right) + 1;
}
