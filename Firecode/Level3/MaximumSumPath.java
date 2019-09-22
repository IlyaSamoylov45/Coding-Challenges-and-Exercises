/*
Given a binary tree consisting of nodes with positive integer values, write a method - maxSumPath that returns the maximum sum of data values obtained by traversing nodes along a path between any 2 nodes of the tree. The path must originate and terminate at 2 different nodes of the tree, and the maximum sum is obtained by summing all the data values of the nodes traversed along this path.

Example:

     1
    / \
   2   3     => 18
  / \ / \
 4  5 6  7

Path: 5 -> 2 -> 1 -> 3 -> 7
Max Sum = 5+2+1+3+7 = 18

*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

int max = 0;

public int maxSumPath(TreeNode root) {
    if(root == null){
        return 0;
    }
    maxSumPathSupport(root);
    return max;
}

public int maxSumPathSupport(TreeNode root){
    if(root == null){
        return 0;
    }
    int left = maxSumPathSupport(root.left);
    int right = maxSumPathSupport(root.right);
    max = Math.max(max, left+right+root.data);
    return Math.max(right,left) + root.data;

}
