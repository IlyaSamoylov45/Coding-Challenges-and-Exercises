/*
Given a
Binary Search Tree
and two numbers - a & b, return all the nodes in the tree that lie in the range [a .. b]. Your method should return an ArrayList with the data of the qualifying nodes inserted in ascending order.


Example:
       4
      / \
     2   8
        / \
       5  10

Range (2,8) ==> [2, 4, 5, 8]

Range includes 2 & 8
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public  ArrayList<Integer> rangeList = new ArrayList<Integer>();
public void printRange(TreeNode root, int a, int b) {
    if(root == null){
        return;
    }
    printRange(root.left, a, b);
    if(a <= root.data && root.data <= b){
        rangeList.add(root.data);
    }
    printRange(root.right, a, b);
}
