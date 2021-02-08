// Given two binary trees original and cloned and given a reference to a node target in the original tree.
//
// The cloned tree is a copy of the original tree.
//
// Return a reference to the same node in the cloned tree.
//
// Note that you are not allowed to change any of the two trees or the target node and the answer must be a reference to a node in the cloned tree.
//
// Follow up: Solve the problem if repeated values on the tree are allowed.
//
//
//
// Example 1:
//
//
// Input: tree = [7,4,3,null,null,6,19], target = 3
// Output: 3
// Explanation: In all examples the original and cloned trees are shown. The target node is a green node from the original tree. The answer is the yellow node from the cloned tree.
// Example 2:
//
//
// Input: tree = [7], target =  7
// Output: 7
// Example 3:
//
//
// Input: tree = [8,null,6,null,5,null,4,null,3,null,2,null,1], target = 4
// Output: 4
// Example 4:
//
//
// Input: tree = [1,2,3,4,5,6,7,8,9,10], target = 5
// Output: 5
// Example 5:
//
//
// Input: tree = [1,2,null,3], target = 2
// Output: 2
//
//
// Constraints:
//
// The number of nodes in the tree is in the range [1, 10^4].
// The values of the nodes of the tree are unique.
// target node is a node from the original tree and is not null.





/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == null || original == target){
            return cloned;
        }
        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        TreeNode right = getTargetCopy(original.right, cloned.right, target);
        return left != null ? left : right;
    }
}
// Time :O(N)
// Space : O(N)







class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root1 = original;
        TreeNode root2 = cloned;
        while(!stack.isEmpty() || root1 != null){
            while(root1!=null){
                stack.push(root1);
                stack.push(root2);
                root1 = root1.left;
                root2 = root2.left;
            }
            root2 = stack.pop();
            root1 = stack.pop();
            if(root1 == target){
                return root2;
            }

            root1 = root1.right;
            root2 = root2.right;

        }
        return null;
    }
}
// Time :O(N)
// Space : O(N)






class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        TreeNode curr1 = original;
        TreeNode curr2 = cloned;
        TreeNode out = null;
        while(curr1 != null){
            if(curr1.left == null){
                if(curr1 == target){
                    out = curr2;
                }
                curr1 = curr1.right;
                curr2 = curr2.right;
            }else{
                TreeNode prev1 = curr1.left;
                TreeNode prev2 = curr2.left;
                while(prev1.right != null && prev1.right != curr1){
                    prev1 = prev1.right;
                    prev2 = prev2.right;
                }
                if(prev1.right == curr1){

                    prev1.right = null;
                    prev2.right = null;
                    if(curr1 == target){
                        out = curr2;
                    }
                    curr1 = curr1.right;
                    curr2 = curr2.right;
                }else{
                    prev1.right = curr1;
                    prev2.right = curr2;
                    curr1 = curr1.left;
                    curr2 = curr2.left;

                }
            }
        }
        return out;
    }
}
// Time : O(N)
// Space : O(1)
