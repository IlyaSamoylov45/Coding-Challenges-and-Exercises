// Given a 'triangle' as an ArrayList of ArrayLists of integers, with each list representing a level of the triangle, find the minimum sum achieved by following a top-down path and adding the integer at each level along the path. Movement is restricted to adjacent numbers from the top to the bottom.
//
// Note:
// - You can only traverse through adjacent nodes while moving up or down the triangle.
// - An adjacent node is defined as a node that is reached by moving down and left or down and right from a level. For eg, in the triangle shown below, if you are at the digit 3 in the second row, its adjacent nodes are 5 and 6
//
// Example:
// Input Triangle:
// [   [1],
//    [2, 3],
//   [4, 5, 6],
// [7, 8, 9, 10],
// ]
//
// Output : 14 (1->2->4->7)
// Note: [..] denotes an ArrayList



// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static int minTriangleDepth(ArrayList<ArrayList<Integer>> input) {
    for(int i = input.size() - 2; i >= 0; i--){
        ArrayList<Integer> prev = input.get(i+1);
        ArrayList<Integer> curr = input.get(i);
        for(int j = 0; j < curr.size(); j++){
            curr.set(j, Math.min(prev.get(j), prev.get(j+1)) + curr.get(j));
        }
    }
    return input.get(0).get(0);
}
// Time : O(n^2)
// Space : O(1)
