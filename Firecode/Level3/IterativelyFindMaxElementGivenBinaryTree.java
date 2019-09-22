/*
Write a method to find the maximum element in a binary tree iteratively.
Examples:
     1
    / \
   2   3     ==>  7
  / \ / \
 4  5 6  7
 */

 // java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public int findMaxItr(TreeNode root) {
    if(root == null){
        return 0;
    }
    TreeNode prev = null;
    TreeNode curr = root;
    int max = curr.data;
    while(curr != null){
        if(curr.left == null){
            if(max < curr.data){
                max = curr.data;
            }
            curr = curr.right;
        }else{
            prev = curr.left;
            while(prev.right != null && prev.right != curr){
        		    prev = prev.right;
        	  }
          	if(prev.right == null){
          	    prev.right = curr;
          	    curr = curr.left;
          	}else{
          	    prev.right = null;
          	    if(max < curr.data){
                      max = curr.data;
                }
                curr = curr.right;
          	}
        }
    }
    return max;
}
