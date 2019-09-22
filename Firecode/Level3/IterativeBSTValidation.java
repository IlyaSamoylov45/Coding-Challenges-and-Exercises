/*
Given the root node of a Binary Tree, write a method - validateBSTItr to iteratively determine if it is a Binary Search Tree.

A BST must satisfy the following conditions :
* The left subtree of a node contains nodes with data < its data.
* The right subtree of a node contains  nodes data > its data.
* A node's left and right subtrees follow the above two conditions.

Examples:


          20
         /   \
       15    30
      /  \
     14  18

    output ==> true

          20
         /   \
       30    15
      /  \
     14  18

   output ==> false
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static boolean validateBSTItr(TreeNode root) {
    if(root == null){
        return true;
    }
    Stack<TreeNode> vals = new Stack<>();
    TreeNode curr = root;
    TreeNode prev = null;
    while(!vals.isEmpty() || curr != null){
        while (curr != null) {
            vals.push(curr);
            curr = curr.left;
        }
        curr = vals.pop();
        if(prev != null && curr.data <= prev.data){
            return false;
        }
        prev = curr;
        curr = curr.right;

    }
    return true;

}
