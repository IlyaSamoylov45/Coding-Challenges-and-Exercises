// Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
//
// For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its zigzag level order traversal as:
// [
//   [3],
//   [20,9],
//   [15,7]
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> values = new ArrayList<>();
        zigzagLevelOrder(root, values, 0);
        return values;
    }

    private void zigzagLevelOrder(TreeNode root, List<List<Integer>> values, int level){
        if(root == null){
            return;
        }
        if(level >= values.size()){
            values.add(new ArrayList<>());
        }
        List<Integer> current = values.get(level);
        if(level%2 != 0){
            current.add(0, root.val);
        }else{
            current.add(root.val);
        }
        zigzagLevelOrder(root.left, values, level + 1);
        zigzagLevelOrder(root.right, values, level + 1);

    }
}
// Time : O(N)
// Space : O(N)






class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> values = new ArrayList<>();
        if(root == null){
            return values;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> current = new LinkedList<>();
            while(size-- > 0){
                TreeNode node = queue.remove();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                if(level%2!=0){
                    current.add(0, node.val);
                }else{
                    current.add(node.val);
                }
            }
            values.add(current);
            level++;
        }
        return values;
    }
}
// Time : O(N)
// Space : O(N)






class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> values = new ArrayList<>();
        TreeNode current = root;
        int level = 0;
        while(current != null){
            if(current.left == null){
                if(level >= values.size()){
                    values.add(new LinkedList<>());
                }
                List<Integer> currentLevel = values.get(level);
                if(level%2!=0){
                    currentLevel.add(0,current.val);
                }else{
                    currentLevel.add(current.val);
                }
                level++;
                current=current.right;
            }else{
                TreeNode prev = current.left;
                int size = 1;
                while(prev.right != null && prev.right != current){
                    size++;
                    prev = prev.right;
                }
                if(prev.right == null){
                    if(level >= values.size()){
                        values.add(new LinkedList<>());
                    }
                    List<Integer> currentLevel = values.get(level);
                    if(level%2!=0){
                            currentLevel.add(0,current.val);
                    }else{
                        currentLevel.add(current.val);
                    }
                    level++;
                    prev.right = current;
                    current=current.left;
                }else{
                    level -= size;
                    prev.right = null;
                    current = current.right;
                }
            }
        }
        return values;
    }
}

// Time : O(N)
// Space : O(1)






class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> values = new ArrayList<>();
        TreeNode current = root;
        int level = 0;
        while(current != null){
            if(current.left == null){
                addValue(values,level,current);
                level++;
                current=current.right;
            }else{
                TreeNode prev = current.left;
                int size = 1;
                while(prev.right != null && prev.right != current){
                    size++;
                    prev = prev.right;
                }
                if(prev.right == null){
                    addValue(values,level,current);
                    level++;
                    prev.right = current;
                    current=current.left;
                }else{
                    level -= size;
                    prev.right = null;
                    current = current.right;
                }
            }
        }
        return values;
    }


    private void addValue(List<List<Integer>> values, int level, TreeNode current){
        if(level >= values.size()){
            values.add(new LinkedList<>());
        }
        List<Integer> currentLevel = values.get(level);
        if(level%2!=0){
                currentLevel.add(0,current.val);
        }else{
            currentLevel.add(current.val);
        }
    }
}
// Time : O(N)
// Space : O(1)
