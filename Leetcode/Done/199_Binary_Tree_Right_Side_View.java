// Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
//
//
//
// Example 1:
//
//
// Input: root = [1,2,3,null,5,null,4]
// Output: [1,3,4]
// Example 2:
//
// Input: root = [1,null,3]
// Output: [1,3]
// Example 3:
//
// Input: root = []
// Output: []
//
//
// Constraints:
//
// The number of nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 100







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
    private List<Integer> values = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        rightSideView(root, 0);
        return values;
    }

    private void rightSideView(TreeNode root, int level){
        if(root == null){
            return;
        }
        if(level >= values.size()){
            values.add(root.val);
        }
        rightSideView(root.right, level + 1);
        rightSideView(root.left, level + 1);
    }
}
// Time : O(N)
// Space : O(N)







class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return values;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            values.add(queue.peek().val);
            int size = queue.size();
            while(size-- > 0){
                TreeNode curr = queue.remove();
                if(curr.right != null){
                    queue.offer(curr.right);
                }
                if(curr.left != null){
                    queue.offer(curr.left);
                }
            }
        }
        return values;
    }
}
// Time : O(N)
// Space : O(N)







class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        TreeNode current = root;
        int level = 0;
        while(current != null){
            if(current.right == null){
                if(level >= values.size()){
                    values.add(current.val);
                }
                level++;
                current = current.left;
            }else{
                TreeNode prev = current.right;
                int diff = 1;
                while(prev.left != null && prev.left != current){
                    prev = prev.left;
                    diff++;
                }
                if(prev.left == null){
                    prev.left = current;
                    if(level >= values.size()){
                        values.add(current.val);
                    }
                    current = current.right;
                    level++;
                }else{
                    prev.left = null;
                    level -= diff;
                    current = current.left;
                }
            }
        }
        return values;
    }


}
// Time : O(N)
// Space : O(1)
