// Given an array of numbers arr. A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.
//
// Return true if the array can be rearranged to form an arithmetic progression, otherwise, return false.
//
//
//
// Example 1:
//
// Input: arr = [3,5,1]
// Output: true
// Explanation: We can reorder the elements as [1,3,5] or [5,3,1] with differences 2 and -2 respectively, between each consecutive elements.
// Example 2:
//
// Input: arr = [1,2,4]
// Output: false
// Explanation: There is no way to reorder the elements to obtain an arithmetic progression.
//
//
// Constraints:
//
// 2 <= arr.length <= 1000
// -10^6 <= arr[i] <= 10^6






class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int val = arr[0] - arr[1];
        for(int i = 1; i < arr.length - 1; i++){
            if(val != arr[i] - arr[i + 1]){
                return false;
            }
        }
        return true;
    }
}
// Time : O(NLog(N))
// Space : O(1)






class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();

        for(int x : arr){
            min = Math.min(x, min);
            max = Math.max(x, max);
            set.add(x);
        }

        int d = max - min;
        if(d % (n - 1) != 0){
            return false;
        }
        d /= n - 1;
        int i = 0;
        while(i < n){
            if(!set.contains(min)){
                return false;
            }
            min += d;
            i++;
        }
        return true;
    }
}
// Time : O(N)
// Space : O(N)
