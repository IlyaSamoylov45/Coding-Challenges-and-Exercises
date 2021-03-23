// You are given a list of songs where the ith song has a duration of time[i] seconds.
//
// Return the number of pairs of songs for which their total duration in seconds is divisible by 60. Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.
//
//
//
// Example 1:
//
// Input: time = [30,20,150,100,40]
// Output: 3
// Explanation: Three pairs have a total duration divisible by 60:
// (time[0] = 30, time[2] = 150): total duration 180
// (time[1] = 20, time[3] = 100): total duration 120
// (time[1] = 20, time[4] = 40): total duration 60
// Example 2:
//
// Input: time = [60,60,60]
// Output: 3
// Explanation: All three pairs have a total duration of 120, which is divisible by 60.
//
//
// Constraints:
//
// 1 <= time.length <= 6 * 104
// 1 <= time[i] <= 500






class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        for(int i = 0; i < time.length; i++){
            for(int j = i + 1; j < time.length; j++){
                count += (time[i] + time[j]) % 60 == 0 ? 1 : 0;
            }
        }
        return count;
    }
}
// Time : O(N^2)
// Space : O(N)







class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] bucket = new int[501];
        int count = 0;
        for(int t : time){
            int i = 60-t%60;
            while(i < bucket.length){
                count += bucket[i];
                i += 60;
            }

            bucket[t]++;
        }
        return count;
    }
}
// Time : O(N)
// Space : O(1)







class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] bucket = new int[60];
        int count = 0;
        for(int t : time){
            if (t % 60 == 0) {
                count += bucket[0];
            }else{
                count += bucket[60-t%60];
            }
            bucket[t % 60]++;
        }
        return count;
    }
}
// Time : O(N)
// Space : O(1)
