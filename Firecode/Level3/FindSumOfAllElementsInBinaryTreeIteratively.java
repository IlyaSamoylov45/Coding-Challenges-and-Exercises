/*
Given a binary tree, write a method to find and return the sum of all nodes of the tree iteratively.
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

public int sumItr(TreeNode root) {
    if(root == null){
        return 0;
    }
    int sum = 0;
    TreeNode prev = null;
    TreeNode curr = root;
    while(curr != null){
        if(curr.left == null){
            sum += curr.data;
            curr = curr.right;
        }else{
            prev = curr.left;
            while(prev.right != null && prev.right != curr){
                prev = prev.right;
            }
            if(prev.right == null){
                prev.right = curr;
                curr = curr.left;
            }else{
                prev.right = null;
                sum += curr.data;
                curr = curr.right;
            }
        }
    }
    return sum;
}
