// Traverse a given binary tree in the Reverse Level Order. Mark a node as visited by adding its data to an ArrayList which will be returned.
// Example:
//      1
//     / \
//    2   3
//   / \ / \
//  4  5 6  7
//
// Output => 4567231



// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public ArrayList<Integer> levelorderRev(TreeNode root) {
    if(root == null){
        return null;
    }
    ArrayList<Integer> values = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while(!queue.isEmpty()){
        TreeNode curr = queue.remove();
        values.add(curr.data);
        if(curr.right != null){
            queue.offer(curr.right);
        }
        if(curr.left != null){
            queue.offer(curr.left);
        }
    }
    Collections.reverse(values);
    return values;
}
// Time : O(N)
// Space : O(N)
