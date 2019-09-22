/*
Write a function to find the total number of half nodes in a binary tree. A half node is a node which has exactly one child node. If there are no half nodes, return 0.
Example:
       1
      / \
     2   3
    / \ / \
   4  5 6  7
  /
 8

Half nodes count => 1
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public int numberOfHalfNodes(TreeNode root) {
    if(root == null){
        return 0;
    }
    int self = 0;
    if(root.left == null ^ root.right == null){
        self++;
    }
    return self + numberOfHalfNodes(root.left) + numberOfHalfNodes(root.right);
}
