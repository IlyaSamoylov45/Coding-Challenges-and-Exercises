// You are given an array representing a row of seats where seats[i] = 1 represents a person sitting in the ith seat, and seats[i] = 0 represents that the ith seat is empty (0-indexed).
//
// There is at least one empty seat, and at least one person sitting.
//
// Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.
//
// Return that maximum distance to the closest person.
//
//
//
// Example 1:
//
//
// Input: seats = [1,0,0,0,1,0,1]
// Output: 2
// Explanation:
// If Alex sits in the second open seat (i.e. seats[2]), then the closest person has distance 2.
// If Alex sits in any other open seat, the closest person has distance 1.
// Thus, the maximum distance to the closest person is 2.
// Example 2:
//
// Input: seats = [1,0,0,0]
// Output: 3
// Explanation:
// If Alex sits in the last seat (i.e. seats[3]), the closest person is 3 seats away.
// This is the maximum distance possible, so the answer is 3.
// Example 3:
//
// Input: seats = [0,1]
// Output: 1
//
//
// Constraints:
//
// 2 <= seats.length <= 2 * 10^4
// seats[i] is 0 or 1.
// At least one seat is empty.
// At least one seat is occupied.



class Solution {
    public int maxDistToClosest(int[] seats) {
        int count = 1;
        int j = 0;
        while(j < seats.length && seats[j] != 1){
            j++;
        }
        for(int i = j; i < seats.length; i++){
            if(seats[i] == 1){
                count = 1;
            }else{
                seats[i] = ++count;
            }
        }
        count = 1;
        j = seats.length - 1;
        while(j >= 0 && seats[j] != 1){
            j--;
        }
        for(int i = j; i >= 0; i--){
            if(seats[i] == 1){
                count = 1;
            }else if(seats[i] == 0){
                seats[i] = ++count;
            }else{
                seats[i] = Math.min(seats[i], ++count);
            }
        }
        int max_distance = -1;
        for(int i = 0; i < seats.length; i++){
            if(max_distance < seats[i]){
                max_distance = seats[i];
            }
        }
        return max_distance - 1;
    }
}
// Time : O(N)
// Space :O(1)




// Cleaner than the solution above.
class Solution {
    public int maxDistToClosest(int[] seats) {
        int N = seats.length;
        int K = 0;
        int ans = 0;
        while(seats[ans] == 0){
            ++ans;
        }
        for(int i = ans + 1; i < seats.length; i++){
            if(seats[i] == 1){
                K = 0;
            }else{
                K++;
            }
            ans = Math.max(ans, (K+1)/2);
        }


        return Math.max(ans, K);
    }
}
// Time : O(N)
// Space :O(1)




class Solution {
    public int maxDistToClosest(int[] seats) {
        int prev = -1;
        int curr = 0;
        int ans = 0;
        int N = seats.length;
        for(int i = 0; i < N; i++){
            if(seats[i] == 1){
                prev = i;
            }else{
                while((curr < N && seats[curr] == 0) || curr < i){
                    curr++;
                }
                int left = prev == -1 ? N : i - prev;
                int right = curr == N ? N : curr - i;
                ans = Math.max(Math.min(left, right), ans);
            }
        }
        return ans;
    }
}
