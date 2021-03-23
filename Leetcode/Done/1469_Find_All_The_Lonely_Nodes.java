// In a binary tree, a lonely node is a node that is the only child of its parent node. The root of the tree is not lonely because it does not have a parent node.
//
// Given the root of a binary tree, return an array containing the values of all lonely nodes in the tree. Return the list in any order.
//
//
//
// Example 1:
//
//
// Input: root = [1,2,3,null,4]
// Output: [4]
// Explanation: Light blue node is the only lonely node.
// Node 1 is the root and is not lonely.
// Nodes 2 and 3 have the same parent and are not lonely.
// Example 2:
//
//
// Input: root = [7,1,4,6,null,5,3,null,null,null,null,null,2]
// Output: [6,2]
// Explanation: Light blue nodes are lonely nodes.
// Please remember that order doesn't matter, [2,6] is also an acceptable answer.
// Example 3:
//
//
//
// Input: root = [11,99,88,77,null,null,66,55,null,null,44,33,null,null,22]
// Output: [77,55,33,66,44,22]
// Explanation: Nodes 99 and 88 share the same parent. Node 11 is the root.
// All other nodes are lonely.
// Example 4:
//
// Input: root = [197]
// Output: []
// Example 5:
//
// Input: root = [31,null,78,null,28]
// Output: [78,28]
//
//
// Constraints:
//
// The number of nodes in the tree is in the range [1, 1000].
// Each node's value is between [1, 10^6].








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
    List<Integer> lst = new ArrayList<>();

    public List<Integer> getLonelyNodes(TreeNode root) {
        if(root == null){
            return lst;
        }
        if(root.left == null && root.right != null){
            lst.add(root.right.val);
        }
        if(root.left != null && root.right == null){
            lst.add(root.left.val);
        }
        getLonelyNodes(root.left);
        getLonelyNodes(root.right);
        return lst;
    }
}
// Time : O(N)
// Space : O(N)








class Solution {

    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        getLonelyNodes(root, false, lst);
        return lst;
    }

    private void getLonelyNodes(TreeNode root, boolean lonely, List<Integer> lst){
        if(root == null){
            return;
        }
        if(lonely){
            lst.add(root.val);
        }
        getLonelyNodes(root.left, root.right == null, lst);
        getLonelyNodes(root.right, root.left == null, lst);
    }
}
// Time : O(N)
// Space : O(N)








class Solution {

    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root != null){
            stack.push(root);
            while(!stack.isEmpty()){
                TreeNode current = stack.pop();
                if(current == null && stack.peek() == null){
                    stack.pop();
                    continue;
                }else if(current == null){
                    if(stack.peek() != null){
                        current = stack.pop();
                    }
                    lst.add(current.val);
                }else if(!stack.isEmpty() && stack.peek() == null){
                    stack.pop();
                    lst.add(current.val);
                }
                stack.push(current.left);
                stack.push(current.right);
            }
        }
        return lst;
    }

}
// Time : O(N)
// Space : O(N)







class Solution {
    public List<Integer> getLonelyNodes(TreeNode root) {

            List<Integer> lst = new ArrayList<Integer>();
            Stack<TreeNode> stack = new Stack<>();

            if(root != null) {
                stack.push(root);

                while(!stack.isEmpty()) {
                    TreeNode curr = stack.pop();

                    if(curr.left == null || curr.right == null) {
                        if(curr.left != null) {
                            stack.push(curr.left);
                            lst.add(curr.left.val);
                        }

                        if(curr.right != null) {
                            stack.push(curr.right);
                            lst.add(curr.right.val);
                        }
                    } else {
                        stack.push(curr.left);
                        stack.push(curr.right);
                    }
                }
            }

            return lst;
        }
}
// Time : O(N)
// Space : O(N)
