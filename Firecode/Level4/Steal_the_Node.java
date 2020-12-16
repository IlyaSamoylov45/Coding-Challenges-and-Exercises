// Write a method to delete a node from a given
// binary search tree
// .
//
// Example:
//    4                     4
//   / \                   / \
//  2   8   delete 10 =>  2   8
//     / \                   /
//    5  10                 5



// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public TreeNode delete(TreeNode root, int data) {
    if(root == null){
        return null;
    }
    if(root.data < data){
        root.right = delete(root.right, data);
    }else if(root.data > data){
        root.left = delete(root.left, data);
    }else{
        if(root.left == null && root.right == null){
            return null;
        }else if(root.left == null){
            return delete(root.right, data);
        }else if(root.right == null){
            return delete(root.left, data);
        }else{
            root.data = findMin(root.right).data;
            root.right = delete(root.right, root.data);
        }
    }
    return root;
}
// Time : O(Log(N))
// Space : O(Log(N))
