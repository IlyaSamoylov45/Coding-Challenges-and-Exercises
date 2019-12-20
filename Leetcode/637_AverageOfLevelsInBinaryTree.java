/**
Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
Note:
The range of node's value is in the range of 32-bit signed integer.
**/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> level = new LinkedList<>();
        List<Double> avgLevels = new LinkedList<>();
        if(root == null){
            return avgLevels;
        }
        level.offer(root);
        while(!level.isEmpty()){
            int size = level.size();
            int totalSize = size;
            double sum = 0;
            while(size-- > 0){
                TreeNode curr = level.remove();
                sum += curr.val;
                if(curr.left != null){
                    level.offer(curr.left);
                }
                if(curr.right != null){
                    level.offer(curr.right);
                }
            }
            avgLevels.add((double)sum/totalSize);
        }
        return avgLevels;
    }
}
