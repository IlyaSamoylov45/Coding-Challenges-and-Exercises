// Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.
//
// Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows
//
// a, b are from arr
// a < b
// b - a equals to the minimum absolute difference of any two elements in arr
//
//
// Example 1:
//
// Input: arr = [4,2,1,3]
// Output: [[1,2],[2,3],[3,4]]
// Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
// Example 2:
//
// Input: arr = [1,3,6,10,15]
// Output: [[1,3]]
// Example 3:
//
// Input: arr = [3,8,-10,23,19,-4,-14,27]
// Output: [[-14,-10],[19,23],[23,27]]
//
//
// Constraints:
//
// 2 <= arr.length <= 10^5
// -10^6 <= arr[i] <= 10^6


class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> values = new ArrayList<>();
        int diff = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length - 1; i++){
            int newDiff = Math.abs(arr[i] - arr[i+1]);
            if(newDiff < diff){
                diff = newDiff;
                values.clear();
                List<Integer> curr = new ArrayList<>();
                curr.add(arr[i]);
                curr.add(arr[i+1]);
                values.add(curr);
            }else if(newDiff == diff){
                List<Integer> curr = new ArrayList<>();
                curr.add(arr[i]);
                curr.add(arr[i+1]);
                values.add(curr);
            }
        }
        return values;
    }
}
//Time : O(NLogN)
//Space : O(N)




class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> values = new ArrayList<>();
        int diff = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length - 1; i++){
            int newDiff = Math.abs(arr[i] - arr[i+1]);
            if(newDiff < diff){
                diff = newDiff;
                values.clear();
                values.add(Arrays.asList(arr[i], arr[i+1]));
            }else if(newDiff == diff){
                List<Integer> curr = new ArrayList<>();

                values.add(Arrays.asList(arr[i], arr[i+1]));
            }
        }
        return values;
    }
}
//Time : O(NLogN)
//Space : O(N)
