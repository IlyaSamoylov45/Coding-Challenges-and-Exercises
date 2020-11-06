// In Computer Science, serialization is the process of converting objects or data structures into a sequence (or series) of characters that can be stored easily in a file / database table or transmitted across a network. Serialized objects need to be de-serialized to create a semantically identical clone of the original object, before being used in programs. You're given the root node of a binary tree - TreeNode root in the method serializeTree. This method should serialize the binary tree and output a String str, which is then used as an input parameter for the method restoreTree. restoreTree should create a Binary Tree that is structurally identical to the one you serialized and return the root node of the tree. Your task is to fill in the logic for these 2 methods. Don't worry about passing the serialized String to restoreTree - that will be done automatically when you run your code. Feel free to use any notation you prefer when serializing the binary tree. The choice of traversal algorithm is also open - but try and limit the time complexity of both methods to O(n).
//
// Note:
// Your serialized String will be used to restore the tree. Be sure to use the same format and notation in restoreTree that you use to serialize in  serializeTree .
//
// Example:
//      1
//     / \
//    2   3
//
// Serialization :
// Output => "1,2,3"
//
// Restoring Tree from "1,2,3" :
// Output ->
//
//      1
//     / \
//    2   3

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public String serializeTree(TreeNode root){
    StringBuilder sb = new StringBuilder();
    Queue<TreeNode> queue = new LinkedList<>();
    String prefix = "";
    queue.offer(root);
    while(!queue.isEmpty()){
        TreeNode curr = queue.poll();
        sb.append(prefix);
        prefix = ",";
        sb.append(curr == null ? "*" : curr.data);
        if(curr != null){
            queue.offer(curr.left);
            queue.offer(curr.right);
        }
    }
    return sb.toString();
}

public TreeNode restoreTree(String str){
    String[] nodes = str.split(",");
    if(nodes[0].equals("*")){
        return null;
    }
    // System.out.println(nodes[0]);
    TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    for(int i = 0; i < nodes.length-2; i+=2){
        TreeNode curr = queue.poll();
        if(curr == null){
            continue;
        }
        curr.left = (nodes[i+1].equals("*") ? null : new TreeNode(Integer.valueOf(nodes[i+1])));
        queue.offer(curr.left);
        curr.right = (nodes[i+2].equals("*") ? null : new TreeNode(Integer.valueOf(nodes[i+2])));
        queue.offer(curr.right);
    }
    return root;
}
