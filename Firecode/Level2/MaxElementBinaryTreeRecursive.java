/*
Given a binary tree, write a recursive method to return the maximum element.
Examples:
     1
    / \
   2   3     ==>  7
  / \ / \
 4  5 6  7
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public int findMax(TreeNode root) {
    if(root == null){
        return Integer.MIN_VALUE;
    }
    int curr = root.data;
    int left = findMax(root.left);
    int right = findMax(root.right);
    if(curr < left){
        curr = left;
    }
    if(curr < right){
        curr = right;
    }
    return curr;
}
