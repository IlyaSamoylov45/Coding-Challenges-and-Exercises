/*
Implement a method to insert a node into a
Binary Search Tree
. Return the root of the modified tree.

Example:

  4                    4
 / \                  / \
2   8   insert(6)=>  2   8
   / \                  / \
  5  10                5  10
                        \
                         6
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public TreeNode insert(TreeNode root, int data) {
    if(root == null){
        return new TreeNode(data);
    }
    if(root.data > data){
        root.left = insert(root.left, data);
    }
    if(root.data < data){
        root.right = insert(root.right, data);
    }
    return root;
}
