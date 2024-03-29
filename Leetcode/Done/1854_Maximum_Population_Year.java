// You are given a 2D integer array logs where each logs[i] = [birthi, deathi] indicates the birth and death years of the ith person.
//
// The population of some year x is the number of people alive during that year. The ith person is counted in year x's population if x is in the inclusive range [birthi, deathi - 1]. Note that the person is not counted in the year that they die.
//
// Return the earliest year with the maximum population.
//
//
//
// Example 1:
//
// Input: logs = [[1993,1999],[2000,2010]]
// Output: 1993
// Explanation: The maximum population is 1, and 1993 is the earliest year with this population.
// Example 2:
//
// Input: logs = [[1950,1961],[1960,1971],[1970,1981]]
// Output: 1960
// Explanation:
// The maximum population is 2, and it had happened in years 1960 and 1970.
// The earlier year between them is 1960.
//
//
// Constraints:
//
// 1 <= logs.length <= 100
// 1950 <= birthi < deathi <= 2050





class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] bucket = new int[2051];
        for(int[] log : logs){
            for(int i = log[0]; i < log[1]; i++){
                bucket[i]++;
            }
        }
        int max = -1;
        int index = -1;
        for(int i = 0; i < bucket.length; i++){
            if(max < bucket[i]){
                max = bucket[i];
                index = i;
            }
        }

        return index;
    }
}
// Time : O(N)
// Space : O(2051) = O(1)






class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] bucket = new int[2051];
        for(int[] log : logs){
            bucket[log[0]]++;
            bucket[log[1]]--;
        }
        int res = 0;
        for(int i = 1; i < bucket.length; i++){
            bucket[i] += bucket[i - 1];
            res = bucket[i] > bucket[res] ? i : res;
        }

        return res;
    }
}
// Time : O(N)
// Space : O(2051) = O(1)





class Solution {
    public int maximumPopulation(int[][] logs) {
        int size = 1051;
        int[] bucket = new int[size];
        for(int[] log : logs){
            bucket[log[0] - size]++;
            bucket[log[1] - size]--;
        }
        int res = 0;
        for(int i = 1; i < bucket.length; i++){
            bucket[i] += bucket[i - 1];
            res = bucket[i] > bucket[res] ? i : res;
        }

        return res + size;
    }
}
// Time : O(N)
// Space : O(1051) = O(1)
