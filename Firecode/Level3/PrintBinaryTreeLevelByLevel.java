/*
Given a binary tree, write a method to print the tree level by level.

Example:
     1
    / \
   2   3
  / \ / \
 4  5 6  7

  ==>  [1][2, 3][4, 5, 6, 7]


Note: Each item in the list is an ArrayList of the format [A[], B,[] .....], where A[],B[].... are the nodes at a particular level, stored in an ArrayList.
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public ArrayList<ArrayList<Integer>> printLevelByLevel(TreeNode root) {
    ArrayList<ArrayList<Integer>> levels = new ArrayList<>();
    if(root == null){
        return levels;
    }
    Queue<TreeNode> vals = new LinkedList<>();
    vals.offer(root);
    while(!vals.isEmpty()){
        int size = vals.size();
        ArrayList<Integer> currLevel = new ArrayList<>();
        while(size > 0){
            TreeNode curr = vals.remove();
            currLevel.add(curr.data);
            if(curr.left != null){
                vals.offer(curr.left);
            }
            if(curr.right != null){
                vals.offer(curr.right);
            }
            size--;
        }

        levels.add(currLevel);
    }
    return levels;
}
