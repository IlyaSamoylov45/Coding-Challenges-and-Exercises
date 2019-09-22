/*
Given a binary tree, write a method to find and return its deepest node. Return null for an empty tree.
Example:
       1
      / \
     2   3     ==> deepest = 9
    / \ / \
   4  5 6  7
  / \
 8   9
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public TreeNode findDeepest(TreeNode root) {
    if(root == null){
        return root;
    }
    Queue<TreeNode> li = new LinkedList<>();
    li.offer(root);
    TreeNode curr = null;
    while(!li.isEmpty()){
        int size = li.size();
        while(size > 0){
            curr = li.remove();
            if(curr.left != null){
                li.offer(curr.left);
            }

            if(curr.right != null){
                li.offer(curr.right);
            }
            size--;
        }
    }
    return curr;
}
