// Given the root of a binary tree, return the maximum average value of a subtree of that tree. Answers within 10-5 of the actual answer will be accepted.
//
// A subtree of a tree is any node of that tree plus all its descendants.
//
// The average value of a tree is the sum of its values, divided by the number of nodes.
//
//
//
// Example 1:
//
//
// Input: root = [5,6,1]
// Output: 6.00000
// Explanation:
// For the node with value = 5 we have an average of (5 + 6 + 1) / 3 = 4.
// For the node with value = 6 we have an average of 6 / 1 = 6.
// For the node with value = 1 we have an average of 1 / 1 = 1.
// So the answer is 6 which is the maximum.
// Example 2:
//
// Input: root = [0,null,1]
// Output: 1.00000
//
//
// Constraints:
//
// The number of nodes in the tree is in the range [1, 104].
// 0 <= Node.val <= 10^5





/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private double max = 0;

    public double maximumAverageSubtree(TreeNode root) {
        helper(root);
        return max;

    }

    private int[] helper(TreeNode root){
        if(root == null){
            return new int[]{0, 0};
        }

        int[] left = helper(root.left);
        int[] right =  helper(root.right);
        int sum = root.val + left[0] + right[0];
        int count = left[1] + right[1] + 1;
        double average = (sum)/(count * 1.0);
        max = Math.max(max, average);

        return new int[]{sum, count};

    }
}
// Time : O(N)
// Space : O(N)






class Solution {

    public double maximumAverageSubtree(TreeNode root) {
        double max = 0;
        int[] defaultAvg = {0, 0};
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, int[]> avg = new HashMap<>();
        TreeNode node = root;
        TreeNode lastVisit = root;
        while(!stack.isEmpty() || node != null){
            while(node != null){
                stack.push(node);
                avg.put(node, new int[]{node.val, 1});
                node = node.left;
            }

            node = stack.peek();

            if(node.right == null || lastVisit == node.right){
                int[] left = avg.getOrDefault(node.left, defaultAvg);
                int[] right = avg.getOrDefault(node.right, defaultAvg);
                int[] current = avg.get(node);
                int val = left[0] + right[0] + current[0];
                int count = left[1] + right[1] + current[1];
                double average = val/(count * 1.0);
                max = Math.max(average, max);
                
                avg.put(node, new int[]{val, count});
                stack.pop();
                lastVisit = node;
                node = null;
            }else{
                node = node.right;
            }
        }
        return max;

    }
}
// Time : O(N)
// Space : O(N)






class Solution {

    private double max = 0;
    private int[] defaultAvg = {0, 0};

    public double maximumAverageSubtree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, int[]> avg = new HashMap<>();
        TreeNode node = root;
        TreeNode lastVisit = root;
        while(!stack.isEmpty() || node != null){
            while(node != null){
                stack.push(node);
                avg.put(node, new int[]{node.val, 1});
                node = node.left;
            }

            node = stack.peek();

            if(node.right == null || lastVisit == node.right){
                calculate(node, avg);
                stack.pop();
                lastVisit = node;
                node = null;
            }else{
                node = node.right;
            }

        }
        return max;
    }

    private void calculate(TreeNode node, Map<TreeNode, int[]> avg){
        int[] left = avg.getOrDefault(node.left, defaultAvg);
        int[] right = avg.getOrDefault(node.right, defaultAvg);
        int[] current = avg.get(node);
        int val = left[0] + right[0] + current[0];
        int count = left[1] + right[1] + current[1];
        double average = val/(count * 1.0);
        max = Math.max(average, max);
        avg.put(node, new int[]{val, count});
    }
}
// Time : O(N)
// Space : O(N)
