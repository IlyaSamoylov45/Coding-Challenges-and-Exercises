// Given the root of a Binary Tree  and 2 integers that represent the data values of any two TreeNodes present in the tree, write a method - getNodeDistance that returns the distance between the nodes. You can assume that the given keys exist in the tree. The distance between two nodes is defined as the minimum number of edges that must be traversed to travel between the two nodes.
//
// Example:
//        1
//       / \
//      2   3
//       \   \
//        4   5
//
// getNodeDistance(2,5) => 3



// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public int getNodeDistance(TreeNode root, int n1, int n2) {
    int dist1 = distance(root, n1);
    int dist2 = distance(root, n2);
    int ancestor = getAncestor(root, n1, n2).data;
    int ancestorDist = distance(root, ancestor);
    return (dist1+dist2) - 2 * ancestorDist;
}


private int distance(TreeNode root, int data){
    if(root == null){
        return 0;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int level = 0;
    while(!queue.isEmpty()){
        int size = queue.size();
        while(size-- > 0){
            TreeNode curr = queue.remove();
            if(curr.data == data){
                return level;
            }
            if(curr.left != null){
                queue.offer(curr.left);
            }
            if(curr.right != null){
                queue.offer(curr.right);
            }
        }
        level++;
    }
    return level;
}


private TreeNode getAncestor(TreeNode root, int n1, int n2){
    if(root == null){
        return null;
    }
    if(root.data == n1 || root.data == n2){
        return root;
    }
    TreeNode left = getAncestor(root.left, n1, n2);
    TreeNode right = getAncestor(root.right, n1, n2);
    if(left != null && right != null){
        return root;
    }
    return left != null ? left : right;
}
// Time : O(N)
// Space : O(N)
