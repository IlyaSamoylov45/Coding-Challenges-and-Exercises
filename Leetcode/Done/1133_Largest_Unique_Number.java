// Given an array of integers A, return the largest integer that only occurs once.
//
// If no integer occurs once, return -1.
//
//
//
// Example 1:
//
// Input: [5,7,3,9,4,9,8,3,1]
// Output: 8
// Explanation:
// The maximum integer in the array is 9 but it is repeated. The number 8 occurs only once, so it's the answer.
// Example 2:
//
// Input: [9,9,8,8]
// Output: -1
// Explanation:
// There is no number that occurs only once.
//
//
// Note:
//
// 1 <= A.length <= 2000
// 0 <= A[i] <= 1000






class Solution {
    public int largestUniqueNumber(int[] A) {
        if(A.length <= 1){
            return A[0];
        }
        Arrays.sort(A);
        int n = A.length - 1;
        if( n - 1 >= 0 && A[n] != A[n-1]){
            return A[n];
        }
        for(int i = n - 1; i > 0; i--){
            if (A[i-1] != A[i] && A[i] != A[i+1]){
                return A[i];
            }
        }
        return A[0] != A[1] ? A[0] : -1;
    }
}
// Time : O(NLogN)
// Space : O(1)







class Solution {
    public int largestUniqueNumber(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : A){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int max = -1;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            if(key > max && value == 1){
                max = key;
            }
        }
        return max;
    }
}
// Time : O(N)
// Space : O(N)






class Solution {
    public int largestUniqueNumber(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : A){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int max = -1;
        for(int x : A){

            if(x > max && map.get(x) == 1){
                max = x;
            }
        }
        return max;
    }
}
// Time : O(N)
// Space : O(N)





class Solution {
    public int largestUniqueNumber(int[] A) {
        int[] freq = new int[1001];
        for(int num : A){
            ++freq[num];
        }
        for(int num = 1000; num >= 0; --num){
            if(freq[num] == 1){
                return num;
            }
        }
        return -1;
    }
}
// Time : O(N)
// Space : O(1)
