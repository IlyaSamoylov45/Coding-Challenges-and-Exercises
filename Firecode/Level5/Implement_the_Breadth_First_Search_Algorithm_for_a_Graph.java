// Implement a method to find a node in a graph using Breadth First Search. Click 'Use me!' to inspect the Node class and its methods.
// Example:
//
//
//           apple
//          /    \
//      banana   mango
//     /     \    /     Find
//  peach   strawberry
//     \     /
//      cherry
//
// cherry ==> True
//






// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public boolean breadthFirstSearch(Node rootNode, String data){
    if(rootNode == null || data == null){
        return false;
    }
    if(rootNode.visited){
        return false;
    }
    rootNode.visited = !rootNode.visited;

    if(rootNode.data.equals(data)){
        return true;
    }

    for(Node node : rootNode.adjacentNodes){
        if(breadthFirstSearch(node, data)){
            return true;
        }
    }
    return false;
}
// Time : O(N)
// Space : O(N)






public boolean breadthFirstSearch(Node rootNode, String data){
    Queue<Node> queue = new LinkedList<>();
    if(rootNode == null || data == null){
        return false;
    }
    queue.offer(rootNode);
    while(!queue.isEmpty()){
        Node curr = queue.remove();
        if(curr.data.equals(data)){
            return true;
        }
        if(!curr.visited){
            curr.visited = true;
            for(Node temp : curr.adjacentNodes){
                queue.offer(temp);
            }
        }

    }
    return false;
}
// Time : O(N)
// Space : O(N)
