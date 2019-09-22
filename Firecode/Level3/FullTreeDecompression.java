/*
Given a String that represents a Binary Tree, write a method - decompressTree that decompresses that tree (reconstructs the tree) and returns the root TreeNode. The compression algorithm included traversing the tree level by level, from the left to the right. The TreeNode's data values were appended to the String, delimited by commas. Also, null TreeNodes were denoted by appending an asterisk - *. The input String denotes the structure of a Full Binary Tree - i.e. a tree that is structurally balanced. However, the reconstructed tree may not be a full tree as the String included * characters, which represent null TreeNodes.

Note:
You can assume that if a Binary Tree contains k levels, the compressed String will contain 2k-1 elements - either numbers or *.

Examples:

Compressed String : "1,2,3"
Output Tree:
     1
    / \
   2   3

Compressed String : "1,2,3,4,*,6,*"
Output Tree:
     1
    / \
   2   3
  /   /
 4   6

Compressed String : "1,*,2,*,*,*,3"
Output Tree:
     1
      \
       2
        \
         3
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public TreeNode decompressTree(String str){
    if (str == null || str.isEmpty()){
		return null;
    }
    String[] decomposed = str.split(",");
    if (decomposed[0].equals("*")){
		return null;
    }
    TreeNode root = new TreeNode(Integer.parseInt(decomposed[0]));
    Queue<TreeNode> vals = new LinkedList<>();
    vals.offer(root);
    int i = 0;
    while(!vals.isEmpty()){
        TreeNode curr = vals.remove();
        if(curr != null){
            if(2*i + 1 < decomposed.length){
                curr.left = (decomposed[2*i + 1].equals("*")) ? null : new TreeNode(Integer.parseInt(decomposed[2*i + 1]));
                vals.offer(curr.left);
            }
            if(2*i + 2 < decomposed.length){
                curr.right = (decomposed[2*i + 2].equals("*")) ? null : new TreeNode(Integer.parseInt(decomposed[2*i + 2]));
                vals.offer(curr.right);
            }
        }
        i++;
    }
    return root;
}
