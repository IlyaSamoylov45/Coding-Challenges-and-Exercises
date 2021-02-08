// Implement a method to compute the shortest path from source to target in a graph using Djikstra Algorithm. The method should return a List of Vertices denoting the optimal path. Click "Use Me" to understand the Vertex and Edge classes.
//
// Example:
//
//      V2
//     |   \
//     |10  \3
//     |   5 \    7
//     V0 ——-- V1 ——— V4
//       \          /
//        \8       /2
//         \      /
//            V3
//
//  v0 = Rville
//  v1 = Bville
//  v2 = Gville
//  v3 = Oville
//  v4 = Pville
//
// Shortest Path to V3 from V0 = [Rville, Oville]





// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static List<Vertex> getShortestPath(Vertex source, Vertex target) {
    computePaths(source);
    return minDistance(target);
}

private static List<Vertex> minDistance(Vertex target){
    List<Vertex> paths = new LinkedList<>();
    for(Vertex vertex = target; vertex != null; vertex = vertex.previous){
        paths.add(vertex);
    }
    Collections.reverse(paths);
    return paths;
}

private static void computePaths(Vertex source){
    source.minDistance = 0;
    Queue<Vertex> queue = new LinkedList<>();
    queue.offer(source);
    while(!queue.isEmpty()){
        Vertex current = queue.remove();
        for(Edge edge : current.adjacencies){
            Vertex x = edge.target;
            double sum = edge.weight + current.minDistance;
            if(x.minDistance > sum){
                x.minDistance = sum;
                x.previous = current;
                queue.offer(x);
            }
        }
    }
}
