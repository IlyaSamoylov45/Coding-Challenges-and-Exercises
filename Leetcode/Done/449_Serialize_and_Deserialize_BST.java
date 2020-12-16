// Serialization is converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
//
// Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You need to ensure that a binary search tree can be serialized to a string, and this string can be deserialized to the original tree structure.
//
// The encoded string should be as compact as possible.
//
//
//
// Example 1:
//
// Input: root = [2,1,3]
// Output: [2,1,3]
// Example 2:
//
// Input: root = []
// Output: []
//
//
// Constraints:
//
// The number of nodes in the tree is in the range [0, 10^4].
// 0 <= Node.val <= 10^4
// The input tree is guaranteed to be a binary search tree.





/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String tree = "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr != null){
                queue.offer(curr.left);
                queue.offer(curr.right);
            }
            tree += (curr == null) ? "*," : curr.val + ",";
        }
        return tree.substring(0, tree.length()-1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        TreeNode root = (values[0].equals("*")) ? null : new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 0;
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(current == null){
                continue;
            }
            if(2*i+1 < values.length){
                current.left = (values[2*i+1].equals("*")) ? null : new TreeNode(Integer.parseInt(values[2*i+1]));
                queue.offer(current.left);
            }
            if(2*i+2 < values.length){
                current.right = (values[2*i+2].equals("*")) ? null : new TreeNode(Integer.parseInt(values[2*i+2]));
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }
}
// Time : O(N)
// Space : O(N)





public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("*,");
            return;
        }
        sb.append(root.val + ",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(queue);
    }

    private TreeNode deserialize(Queue<String> queue){
        String current = queue.poll();
        if(current.equals("*")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(current));
        root.left = deserialize(queue);
        root.right = deserialize(queue);
        return root;
    }
}
// Time : O(N)
// Space : O(N)
