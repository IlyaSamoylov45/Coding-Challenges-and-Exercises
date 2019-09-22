/*
Write a function to iteratively determine the total number of "full nodes" in a binary tree. A full node contains left and right child nodes. If there are no full nodes, return 0.
Example:
       1
      / \
     2   3
    / \ / \
   4  5 6  7
  / \
 8   9

Full nodes count ==> 4
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public int numberOfFullNodes(TreeNode root) {
    if(root == null){
        return 0;
    }
    int full = 0;
    Queue<TreeNode> vals = new LinkedList<>();
    vals.offer(root);
    while(!vals.isEmpty()){
        TreeNode curr = vals.remove();
        if(curr == null){
            continue;
        }
        if(curr.left != null && curr.right != null){
            full++;
        }
        vals.offer(curr.left);
        vals.offer(curr.right);
    }
    return full;
}
