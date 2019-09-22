/*
Given the root of a Binary Tree  and an integer that represents the data value of a TreeNode present in the tree, write a method - pathLengthFromRoot that returns the distance between the root and that node. You can assume that the given key exists in the tree. The distance is defined as the minimum number of nodes that must be traversed to reach the target node.

Example:
       1
      / \
     2   3
      \   \
       4   5

pathLengthFromRoot(root,5) => 3
pathLengthFromRoot(root,1) => 1
pathLengthFromRoot(root,3) => 2
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public int pathLengthFromRoot(TreeNode root, int n1) {
    if(root == null){
        return 0;
    }
    if(root.data == n1){
        return 1;
    }
    int left = pathLengthFromRoot(root.left, n1);
    if(left > 0){
        return 1 + left;
    }

    int right = pathLengthFromRoot(root.right, n1);
    if(right > 0){
        return 1 + right;
    }
    return 0;
}
