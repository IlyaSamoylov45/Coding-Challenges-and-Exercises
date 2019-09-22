/*
Given a
Binary Search Tree
, return the node with the minimum data.
Example:
       4
      / \
     2   8
        / \
       5  10

Output ==> 2
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public TreeNode findMin(TreeNode root) {
    if(root == null){
        return root;
    }
    TreeNode curr = root;
    while(curr.left != null){
        curr = curr.left;
    }
    return curr;
}
