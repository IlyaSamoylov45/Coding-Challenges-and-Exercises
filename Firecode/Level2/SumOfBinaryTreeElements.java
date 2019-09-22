/*
Given a binary tree, write a method to find and return the sum of all the elements using recursion. For an empty tree the sum is 0.

Example:
       1
      / \
     2   3
    / \ / \
   4  5 6  7
  /
 8
  ==> sum of all nodes = 36
  (1+2+3+4+5+6+7+8)
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public int sum(TreeNode root) {
    if(root == null){
        return 0;
    }
    return root.data + sum(root.left) + sum(root.right);
}
