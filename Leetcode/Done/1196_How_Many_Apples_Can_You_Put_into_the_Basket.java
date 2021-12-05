// You have some apples, where arr[i] is the weight of the i-th apple.  You also have a basket that can carry up to 5000 units of weight.
//
// Return the maximum number of apples you can put in the basket.
//
//
//
// Example 1:
//
// Input: arr = [100,200,150,1000]
// Output: 4
// Explanation: All 4 apples can be carried by the basket since their sum of weights is 1450.
// Example 2:
//
// Input: arr = [900,950,800,1000,700,800]
// Output: 5
// Explanation: The sum of weights of the 6 apples exceeds 5000 so we choose any 5 of them.
//
//
// Constraints:
//
// 1 <= arr.length <= 10^3
// 1 <= arr[i] <= 10^3






class Solution {
    public int maxNumberOfApples(int[] arr) {
        int[] bucket = new int[1000];
        for(int weight : arr){
            bucket[weight - 1]++;

        }
        int sum = 0;
        int apples = 0;
        for(int i = 0; i < bucket.length; i++){
            if(bucket[i] != 0){
                int take = Math.min(bucket[i], (5000 - sum) / (i + 1));
                if (take == 0) {
                    break;
                }
                sum += take * (i + 1);
                apples += take;
            }
        }
        return apples;
    }
}
// Time : O(N + kLogN)
// Space : O(1000) = O(1)






class Solution {
    public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int sum = 0;
        int i = 0;
        while(i < arr.length){
            if(arr[i] + sum > 5000){
                break;
            }
            sum += arr[i++];
        }
        return i;
    }
}
// Time : O(NLogN)
// Space : O(LogN)
