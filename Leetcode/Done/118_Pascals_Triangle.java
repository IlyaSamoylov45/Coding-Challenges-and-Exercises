// Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
//
//
// In Pascal's triangle, each number is the sum of the two numbers directly above it.
//
// Example:
//
// Input: 5
// Output:
// [
//      [1],
//     [1,1],
//    [1,2,1],
//   [1,3,3,1],
//  [1,4,6,4,1]
// ]


class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> values = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        current.add(1);
        for(int i = 0; i < numRows; i++){
            values.add(new ArrayList<>(current));
            int size = current.size();
            List<Integer> prev = new ArrayList<>(current);
            for(int j = 1; j < size; j++){
                current.set(j, prev.get(j) + prev.get(j-1));
            }
            current.add(1);
        }
        return values;
    }
}

//Time complexity : O(numRows^2)
//Space complexity : O(numRows^2)


class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> values = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        current.add(1);
        for(int i = 0; i < numRows; i++){
            values.add(new ArrayList<>(current));
            current.add(0, 1);
            for(int j = 1; j < current.size() - 1; j++){
                current.set(j, current.get(j) + current.get(j+1));
            }
        }
        return values;
    }
}
