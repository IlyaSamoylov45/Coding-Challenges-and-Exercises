/*
Given a binary tree, write a method to iteratively traverse the tree in the preorder manner. Mark a node as visited by adding its data to a list - Arraylist <Integer> preorderedList. Return this list.

Example:
     1
    / \
   2   3     ==> 1245367
  / \ / \
 4  5 6  7
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public ArrayList<Integer> preorderItr(TreeNode root) {
    ArrayList<Integer> vals = new ArrayList<>();
    Stack<TreeNode> pre = new Stack<>();
    pre.push(root);
    while(!pre.isEmpty()){
        TreeNode curr = pre.pop();
        vals.add(curr.data);
        if(curr.left!=null){
            pre.push(curr.left);
        }
        if(curr.right!=null){
            pre.push(curr.right);
        }
    }
    return vals;


}
