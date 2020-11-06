// Given a collection of intervals, merge all overlapping intervals.
//
// Example 1:
//
// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
// Example 2:
//
// Input: intervals = [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.
// NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
//
//
//
// Constraints:
//
// intervals[i][0] <= intervals[i][1]


class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> values = new LinkedList<>();

        for(int i = 0; i < intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            int j = i+ 1;
            while(j < intervals.length && intervals[j][0] <= end){
                end = Math.max(intervals[j][1], end);
                j++;
            }
            i = j - 1;
            values.add(new int[]{start, end});
        }
        return values.toArray(new int[values.size()][]);

    }
}
// Time :O(NLogN)
// Space : O(1)
