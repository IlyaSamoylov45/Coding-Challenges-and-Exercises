/**
Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).

Return the roots of the trees in the remaining forest.  You may return the result in any order.



Example 1:



Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
Output: [[1,2,null,4],[6],[7]]


Constraints:

The number of nodes in the given tree is at most 1000.
Each node has a distinct value between 1 and 1000.
to_delete.length <= 1000
to_delete contains distinct values between 1 and 1000.
**/



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 // First Attempt
class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> forest = new LinkedList<>();
        List<Integer> deleteVals = createList(to_delete);
        if(root == null){
            return forest;
        }
        if(!deleteVals.contains(root.val)){
            forest.add(root);
        }
        delNodes(root, deleteVals, forest);
        return forest;
    }
    public TreeNode delNodes(TreeNode root, List<Integer> deleteVals, List<TreeNode> forest) {
        if(root == null){
            return null;
        }
        if(deleteVals.contains(root.val)){
            deleteVals.remove(new Integer(root.val));
            if(root.left != null){
                if(!deleteVals.contains(root.left.val)){
                    forest.add(root.left);
                }
                root.left = delNodes(root.left, deleteVals, forest);
            }
            if(root.right != null){
                if(!deleteVals.contains(root.right.val)){
                    forest.add(root.right);
                }
                root.right = delNodes(root.right, deleteVals, forest);
            }
            return null;
        }
        root.left = delNodes(root.left, deleteVals, forest);
        root.right = delNodes(root.right, deleteVals, forest);
        return root;

    }
    public List<Integer> createList(int[] to_delete){
        List<Integer> currList = new LinkedList<>();
        for(int i = 0; i < to_delete.length; i++){
            currList.add(to_delete[i]);
        }
        return currList;
    }
}

//Second Attempt

class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> forest = new LinkedList<>();
        Set<Integer> set = createList(to_delete);
        if(root == null){
            return forest;
        }
        if(!set.contains(root.val)){
            forest.add(root);
        }
        delNodes(root, set, forest);
        return forest;
    }
    public TreeNode delNodes(TreeNode root, Set<Integer> set, List<TreeNode> forest) {
        if(root == null){
            return null;
        }
        if(set.contains(root.val)){
            set.remove(new Integer(root.val));
            if(root.left != null){
                if(!set.contains(root.left.val)){
                    forest.add(root.left);
                }
                root.left = delNodes(root.left, set, forest);
            }
            if(root.right != null){
                if(!set.contains(root.right.val)){
                    forest.add(root.right);
                }
                root.right = delNodes(root.right, set, forest);
            }
            return null;
        }
        root.left = delNodes(root.left, set, forest);
        root.right = delNodes(root.right, set, forest);
        return root;

    }

    public Set<Integer> createList(int[] to_delete){
        Set<Integer> set = new HashSet<>();
        for(int i : to_delete){
            set.add(i);
        }
        return set;
    }
}

// Clean up
class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> forest = new LinkedList<>();
        Set<Integer> set = createList(to_delete);
        if(root == null){
            return forest;
        }
        if(!set.contains(root.val)){
            forest.add(root);
        }
        delNodes(root, set, forest);
        return forest;
    }
    public TreeNode delNodes(TreeNode root, Set<Integer> set, List<TreeNode> forest) {
        if(root == null){
            return null;
        }
        root.left = delNodes(root.left, set, forest);
        root.right = delNodes(root.right, set, forest);
        if(set.contains(root.val)){
            set.remove(new Integer(root.val));
            if(root.left != null){
                forest.add(root.left);
            }
            if(root.right != null){
                forest.add(root.right);
            }
            return null;
        }
        return root;

    }

    public Set<Integer> createList(int[] to_delete){
        Set<Integer> set = new HashSet<>();
        for(int i : to_delete){
            set.add(i);
        }
        return set;
    }
}
