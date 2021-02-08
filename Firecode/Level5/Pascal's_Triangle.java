// Given an input parameter numRows, generate the first numRows number of rows of Pascal's triangle. As a quick refresher - in a Pascal's triangle, each number is equal to the sum of the two directly above it.
//
// Example:
//
// Input  : 4
// Output :
//         [
//              [1],
//             [1,1],
//            [1,2,1],
//           [1,3,3,1]
//
//         ]






// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.
public static ArrayList<ArrayList<Integer>> generatePascalTriangle(int numRows) {
    ArrayList<ArrayList<Integer>> values = new ArrayList<>();
    if(numRows <= 0){
        return values;
    }
    ArrayList<Integer> current = new ArrayList<>();
    current.add(1);
    for(int i = 1; i <= numRows; i++){
        values.add(new ArrayList<>(current));
        current.add(0, 1);
        for(int j = 1; j < current.size() - 1; j++){
            current.set(j, current.get(j) + current.get(j + 1));
        }
    }
    return values;
}
// Time : O(N^2)
// Space : O(N^2)
