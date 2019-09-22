/*
Given a binary tree, write a method to find and return the node with data = the input data. Do not use recursion.

Example:
       1
      / \
     2   3
    / \ / \
   4  5 6  7

findNode(root, 5) ==> 5

Note: Return null, if desired node is not found.
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public TreeNode findNode(TreeNode root, int val) {
    if(root == null){
        return null;
    }
    Stack<TreeNode> vals = new Stack<>();
    vals.push(root);
    while(!vals.isEmpty()){
        TreeNode curr = vals.pop();
        if(curr.data == val){
            return curr;
        }
        if(curr.left != null){
            vals.push(curr.left);
        }
        if(curr.right != null){
            vals.push(curr.right);
        }
    }
    return null;
}
