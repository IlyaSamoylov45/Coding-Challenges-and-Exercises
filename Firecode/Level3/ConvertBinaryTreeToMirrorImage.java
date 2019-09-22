/*
Write a function to convert a binary tree into its mirror image and return the root node of the mirrored tree.
Example:
       1
      / \
     2   3
    / \ / \
   4  5 6  7

       |
       V
  Mirror Form
       1
      / \
     3   2
    / \ / \
   7  6 5  4

Output = Level Order:[1, 3, 2, 7, 6, 5, 4]
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public TreeNode mirror(TreeNode root) {
    if(root == null){
        return null;
    }
    TreeNode left = root.left;
    root.left = mirror(root.right);
    root.right = mirror(left);
    return root;
}
