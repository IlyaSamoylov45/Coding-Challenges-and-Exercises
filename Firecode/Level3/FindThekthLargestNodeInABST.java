/*
Given a
Binary Search Tree
and an integer k, implement a method to find and return its kth largest node

Example:

       4
      / \
     2   8
        / \
       5  10

K = 2, Output = 8

In the above scenario, if k = 1, then the output is 10 i.e. k = 1, represents the largest element of the tree, k = 2, represents the second largest element and so on.
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public TreeNode findKthLargest(TreeNode root, int k) {
    Stack<TreeNode> vals = new Stack<>();
    if(root == null){
        return root;
    }
    while(true){
        while(root != null){
            vals.add(root);
            root = root.right;
        }
        root = vals.pop();
        if(--k <= 0){
            return root;
        }
        root = root.left;
    }

}
