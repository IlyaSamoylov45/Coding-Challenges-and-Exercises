/*
Given a binary tree, write a method to perform a levelorder traversal and return an ArrayList of integers containing the data of the visited nodes in the correct order.
Example:
     1
    / \
   2   3     ==> 1234567
  / \ / \
 4  5 6  7

*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public ArrayList<Integer> levelorder(TreeNode root) {
    ArrayList<Integer> level = new ArrayList<>();
    if(root == null){
        return level;
    }
    Queue<TreeNode> vals = new LinkedList<>();
    vals.offer(root);
    while(!vals.isEmpty()){
        TreeNode curr = vals.remove();
        level.add(curr.data);
        if(curr.left != null){
            vals.offer(curr.left);
        }
        if(curr.right != null){
            vals.offer(curr.right);
        }
    }
    return level;


}
