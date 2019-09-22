/*
Given a binary tree, write a method to perform the inorder traversal iteratively. Append the data of each node visited to an ArrayList. Return an empty Arraylist in the case of an empty tree.
Example:
     1
    / \
   2   3     ==> 4251637
  / \ / \
 4  5 6  7
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public ArrayList<Integer> inorderItr(TreeNode root) {
    ArrayList<Integer> vals = new ArrayList<>();
    if(root == null){
        return vals;
    }
    Stack<TreeNode> inOrder = new Stack<>();
    TreeNode curr = root;
    while(!inOrder.isEmpty() || curr != null){
        while(curr!=null){
            inOrder.push(curr);
            curr = curr.left;
        }
        curr = inOrder.pop();
        vals.add(curr.data);
        curr = curr.right;
    }
    return vals;

}
