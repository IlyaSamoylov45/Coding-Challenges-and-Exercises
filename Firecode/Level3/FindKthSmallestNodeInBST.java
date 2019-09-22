/*
Given a
binary search tree
and an integer k, implement a method to find and return the kth smallest node.
Example:
       4
      / \
     2   8
        / \
       5  10

K = 2, Output = 4
*/
// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public TreeNode findKthSmallest(TreeNode root, int k) {
    if(root == null){
        return null;
    }
    TreeNode kthSmallest = null;
    TreeNode prev = null;
    TreeNode curr = root;
    while(curr != null){
        if(curr.left == null){
            if(--k == 0){
                kthSmallest = curr;
            }
            curr = curr.right;
            continue;
        }
        prev = curr.left;
        while(prev.right != null && prev.right != curr){
            prev = prev.right;
        }
        if(prev.right == null){
            prev.right = curr;
            curr = curr.left;
        }else{
            prev.right = null;
            if(--k == 0){
                kthSmallest = curr;
            }
            curr = curr.right;
        }

    }
    return kthSmallest;
}
