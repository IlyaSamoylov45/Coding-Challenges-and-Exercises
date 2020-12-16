// Given a binary tree, write a method to return the level that has the maximum sum. In case the tree is empty, return -1
// Example:
//        1
//       / \
//      2   3
//     / \ / \
//    4  5 6  7
//   /
//  8
//
// Output ==> 2
// Note: Assume that root is at level 0.



// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public int findMaxSumLevel(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    int max = -1;
    int maxLevel = -1;
    int currLevel = -1;
    if(root == null){
        return max;
    }
    queue.offer(root);
    while(!queue.isEmpty()){
        currLevel++;
        int currSum = 0;
        int size = queue.size();
        while(size-- > 0){
            TreeNode currNode = queue.remove();
            currSum+=currNode.data;
            if(currNode.left != null){
                queue.offer(currNode.left);
            }
            if(currNode.right != null){
                queue.offer(currNode.right);
            }
        }
        if(currSum > max){
            max = currSum;
            maxLevel = currLevel;
        }

    }
    return maxLevel;



}
