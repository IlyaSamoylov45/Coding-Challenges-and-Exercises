/*
Given the root node of a Binary Tree, determine if it is a Binary Search Tree.

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

public static boolean validateBST(TreeNode root) {
    if(root == null){
        return true;
    }
    return validateBSTSupport(root.left, Integer.MIN_VALUE, root.data)
           || validateBSTSupport(root.right, Integer.MAX_VALUE, root.data);
}

public static boolean validateBSTSupport(TreeNode root, int min, int max){
    if(root==null)
        return true;

    if(root.data <= min || root.data >= max)
        return false;

    return validateBSTSupport(root.left, min, root.data)
           && validateBSTSupport(root.right, root.data, max);
}
