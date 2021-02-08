// Implement a method to find a node in a graph using Depth First Search.
// Example:
//           apple
//          /    \
//      banana   mango
//     /     \    /
//  peach   strawberry
//     \     /
//      cherry
//
// Find cherry ==> true
//






// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public boolean depthFirstSearch(Node rootNode, String data){
    if(rootNode == null || data == null){
        return false;
    }
    Stack<Node> stack = new Stack<>();
    stack.push(rootNode);
    while(!stack.isEmpty()){
        Node node = stack.pop();
        if(node.data.equals(data)){
            return true;
        }
        if(!node.visited){
            for(Node x : node.adjacentNodes){
                stack.push(x);
            }
            node.visited = true;
        }
    }
    return false;
}
// Time : O(N)
// Space : O(N)
