/*
Write a non-recursive method minTreeDepth that takes in the root node of a Binary Tree and returns the minimum depth of the tree. The minimum depth is defined as the least number of node traversals needed to reach a leaf from the root node. Your method should run in linear O(n) time and use at max O(n) space.


Example:

      1
     / \
    2   3
   / \
  4   5

Output : 2
1 -> 3 is the minimum depth, with a 2 node traversal.
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public int minTreeDepth(TreeNode root) {
    if(root == null){
        return 0;
    }
    int left = minTreeDepth(root.left) + 1;
    int right = minTreeDepth(root.right) + 1;
    return Math.min(left, right);
} 
