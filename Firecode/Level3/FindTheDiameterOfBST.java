/*
Given a BST, write a function to return its diameter. The diameter of a Binary Tree is defined as the "Number of nodes on the longest path between two leaf nodes".

Example:
      20
    /     \
   15     30
  /  \      \  diameter ==> 7
 14  18     35
    /  \    /
   17  19  32
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

int max = 0;

public int diameter(TreeNode root) {
    diameterSupport(root);
    return max;
}

public int diameterSupport(TreeNode root){
    if(root == null){
        return 0;
    }
    int left = diameterSupport(root.left);
    int right = diameterSupport(root.right);
    max = Math.max(max, left + right + 1);
    return Math.max(left, right) + 1;
}
