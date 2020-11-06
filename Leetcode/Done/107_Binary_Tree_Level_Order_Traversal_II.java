// Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
//
// For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its bottom-up level order traversal as:
// [
//   [15,7],
//   [9,20],
//   [3]
// ]


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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> values = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root!=null){
            queue.offer(root);
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> current = new LinkedList<>();
            while(size-- > 0){
                TreeNode curr = queue.remove();
                if(curr.left!=null){
                    queue.offer(curr.left);
                }
                if(curr.right!=null){
                    queue.offer(curr.right);

                }
                current.add(curr.val);
            }
            values.addFirst(current);
        }
        return values;
    }
}
// Time : O(N)
// Space : O(N)




class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> values = new LinkedList<>();
        levelOrderBottomSupport(root, values, 0);
        Collections.reverse(values);
        return values;
    }

    private void levelOrderBottomSupport(TreeNode root, List<List<Integer>> values, int level){
        if(root == null){
            return;
        }
        if(values.size() == level){
            values.add(new LinkedList<>());
        }
        List<Integer> current = values.get(level);
        current.add(root.val);
        levelOrderBottomSupport(root.left, values, level+1);
        levelOrderBottomSupport(root.right, values, level+1);
    }
}
// Time : O(N)
// Space : O(N)





class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> values = new LinkedList<>();
        TreeNode prev = null;
        TreeNode current = root;
        int currentLevel = 0;
        while(current != null){
            if(current.left == null){
                if(values.size() == currentLevel){
                    values.add(new LinkedList<>());
                }
                values.get(currentLevel).add(current.val);
                currentLevel++;
                current = current.right;
            }else{
                int delta = 1;
                prev = current.left;
                while(prev.right != null && prev.right != current){
                    prev = prev.right;
                    delta++;
                }
                if(prev.right == null){
                    if(values.size() == currentLevel){
                        values.add(new LinkedList<>());
                    }
                    values.get(currentLevel).add(current.val);
                    currentLevel++;
                    prev.right = current;
                    current = current.left;
                }else{
                    prev.right =null;
                    current = current.right;
                    currentLevel -= delta;
                }
            }
        }
        Collections.reverse(values);
        return values;
    }
}
// Time : O(N)
// Space : O(1)
