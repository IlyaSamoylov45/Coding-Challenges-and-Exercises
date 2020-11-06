// Given two binary trees, write a function to check if they are the same or not.
//
// Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
//
// Example 1:
//
// Input:     1         1
//           / \       / \
//          2   3     2   3
//
//         [1,2,3],   [1,2,3]
//
// Output: true
// Example 2:
//
// Input:     1         1
//           /           \
//          2             2
//
//         [1,2],     [1,null,2]
//
// Output: false
// Example 3:
//
// Input:     1         1
//           / \       / \
//          2   1     1   2
//
//         [1,2,1],   [1,1,2]
//
// Output: false




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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null || p.val != q.val){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

// Time : O(N)
// Space : O(N)





class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (p == null && q == null){
            return true;
        }
        else if (p == null || q == null){
            return false;
        }
        if (p != null && q != null) {
            queue.offer(p);
            queue.offer(q);
        }
        while (!queue.isEmpty()) {
            TreeNode first = queue.poll();
            TreeNode second = queue.poll();
            if (first == null && second == null){
                continue;
            }
            if (first == null || second == null || first.val != second.val){
                return false;
            }
            queue.offer(first.left);
            queue.offer(second.left);
            queue.offer(first.right);
            queue.offer(second.right);
        }
        return true;
    }
}
// Time : O(N)
// Space : O(N)




class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        TreeNode currP = p;
        TreeNode currQ = q;
        while(currP != null && currQ !=  null){
            if(currP.val != currQ.val){
                return false;
            }
            if(currP.right == null && currQ.right == null){
                currP = currP.left;
                currQ = currQ.left;
            }
            else if(currP.right == null || currQ.right == null){
                return false;
            }
            else{
                TreeNode prevP = currP.right;
                TreeNode prevQ = currQ.right;
                while(prevP.left != null && prevP.left != currP && prevQ.left != null && prevQ.left != currQ){
                    prevP = prevP.left;
                    prevQ = prevQ.left;
                }
                if(prevP.left == null && prevQ.left == null){
                    prevP.left = currP;
                    prevQ.left = currQ;
                    currP = currP.right;
                    currQ = currQ.right;
                }else if(prevP.left == null || prevQ.left == null){
                    return false;
                }else if(prevP.left == currP && prevQ.left == currQ){
                    prevP.left = null;
                    prevQ.left = null;
                    currP = currP.left;
                    currQ = currQ.left;
                }else{
                    return false;
                }
            }
        }
        return currP == currQ;
    }
}
// Time O(N)
// Space O(1)
