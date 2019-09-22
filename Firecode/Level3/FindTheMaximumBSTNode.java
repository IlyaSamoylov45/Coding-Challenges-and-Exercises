/*
Given a
Binary Search Tree
, return the node with the maximum data.
Example:
       4
      / \
     2   8
        / \
       5  10

Output ==> 10
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public TreeNode findMax(TreeNode root) {
    if(root == null){
        return root;
    }
    TreeNode curr = root;
    while(curr.right != null){
        curr = curr.right;
    }
    return curr;
}
