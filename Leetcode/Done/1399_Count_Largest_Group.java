// Given an integer n. Each number from 1 to n is grouped according to the sum of its digits.
//
// Return how many groups have the largest size.
//
//
//
// Example 1:
//
// Input: n = 13
// Output: 4
// Explanation: There are 9 groups in total, they are grouped according sum of its digits of numbers from 1 to 13:
// [1,10], [2,11], [3,12], [4,13], [5], [6], [7], [8], [9]. There are 4 groups with largest size.
// Example 2:
//
// Input: n = 2
// Output: 2
// Explanation: There are 2 groups [1], [2] of size 1.
// Example 3:
//
// Input: n = 15
// Output: 6
// Example 4:
//
// Input: n = 24
// Output: 5
//
//
// Constraints:
//
// 1 <= n <= 10^4






class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int max = 0;
        int maxCount = 0;
        for(int i = 1; i <= n; i++){
            int sum = 0;
            int current = i;
            while(current > 0){
                sum += current%10;
                current/=10;
            }
            List<Integer> lst = map.getOrDefault(sum, new LinkedList<>());
            lst.add(i);
            if(lst.size() > max){
                max = lst.size();
                maxCount = 1;
            }else if(lst.size() == max){
                maxCount++;
            }
            map.put(sum, lst);
        }

        return maxCount;

    }
}
// Time : O(N)
// Space : O(N)







class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int maxCount = 0;
        for(int i = 1; i <= n; i++){
            int sum = 0;
            int current = i;
            while(current > 0){
                sum += current%10;
                current/=10;
            }
            int count =  map.getOrDefault(sum, 0) + 1;
            map.put(sum, count);
            if(count > max){
                max = count;
                maxCount = 1;
            }else if(count == max){
                maxCount++;
            }

        }

        return maxCount;

    }
}
// Time : O(N)
// Space : O(N)






class Solution {
    public int countLargestGroup(int n) {
        int[] vals = new int[37];
        int max = 0;
        int maxCount = 0;
        for(int i = 1; i <= n; i++){
            int sum = 0;
            int current = i;
            while(current > 0){
                sum += current%10;
                current/=10;
            }
            vals[sum]++;
            if(vals[sum] > max){
                max = vals[sum];
                maxCount = 1;
            }else if(vals[sum] == max){
                maxCount++;
            }
        }
        return maxCount;

    }
}
// Time : O(N)
// Space : O(1)
