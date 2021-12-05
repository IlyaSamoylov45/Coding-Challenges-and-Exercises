// Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.
//
// An integer a is closer to x than an integer b if:
//
// |a - x| < |b - x|, or
// |a - x| == |b - x| and a < b
//
//
// Example 1:
//
// Input: arr = [1,2,3,4,5], k = 4, x = 3
// Output: [1,2,3,4]
// Example 2:
//
// Input: arr = [1,2,3,4,5], k = 4, x = -1
// Output: [1,2,3,4]
//
//
// Constraints:
//
// 1 <= k <= arr.length
// 1 <= arr.length <= 10^4
// arr is sorted in ascending order.
// -10^4 <= arr[i], x <= 10^4





class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> sortedArr = new ArrayList<>();
        for(int num : arr){
            sortedArr.add(num);
        }

        Collections.sort(sortedArr, (num1, num2) -> Math.abs(num1 - x) - Math.abs(num2 - x));
        sortedArr = sortedArr.subList(0,k);
        Collections.sort(sortedArr);
        return sortedArr;
    }
}
// Time O(Nlog(N)+klog(k))
// Space : O(N)





class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<Integer>();

        if (arr.length == k) {
            for (int i = 0; i < k; i++) {
                result.add(arr[i]);
            }

            return result;
        }

        int left = 0;
        int right = arr.length;
        while(left < right){
            int mid = left + (right - left)/2;
            if(arr[mid] >= x){
                right = mid;
            }else{
                left = mid + 1;
            }

        }
        left -= 1;
        right = left + 1;

        while(right - left - 1 < k){
            if(left == -1){
                right++;
                continue;
            }
            if(right == arr.length || Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)){
                left--;
            }else{
                right++;
            }
        }

        for (int i = left + 1; i < right; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}
// Time : O(LOG(N) + K)
// Space : O(1)





class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<Integer>();

        int left = 0;
        int right = arr.length - k;

        while(left < right){
            int mid = left + (right - left)/2;
            if(x - arr[mid] > arr[mid + k] - x){
                left = mid + 1;
            }else{
                right = mid;
            }
        }

        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}
// Time : O(LOG(N - k) + k)
// Space : O(1)
