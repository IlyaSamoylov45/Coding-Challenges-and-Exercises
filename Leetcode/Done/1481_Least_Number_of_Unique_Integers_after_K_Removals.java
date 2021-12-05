// Given an array of integers arr and an integer k. Find the least number of unique integers after removing exactly k elements.
//
//
//
// Example 1:
//
// Input: arr = [5,5,4], k = 1
// Output: 1
// Explanation: Remove the single 4, only 5 is left.
// Example 2:
// Input: arr = [4,3,1,1,3,3,2], k = 3
// Output: 2
// Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.
//
//
// Constraints:
//
// 1 <= arr.length <= 10^5
// 1 <= arr[i] <= 10^9
// 0 <= k <= arr.length





class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        for(int num : arr){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(Integer i : map.keySet()){
            pq.offer(new int[]{i, map.get(i)});
        }
        while(k > 0 && !pq.isEmpty()){
            int[] peek = pq.peek();
            int remove = Math.min(peek[1], k);
            peek[1] -= remove;
            if(peek[1] == 0){
                pq.remove();
            }
            k -= remove;
        }
        return pq.size();
    }
}
// Time Complexity -O(NLogN)
//
// Generating Map - O(n)
// Putting entries into PriorityQueue - O(nlogn)
// Removing elements from Queue -> O(min(k,N) * logN)
//
// Space Complexity : O(N)
//
// Map - O(n)
// PriorityQueue - O(n)







class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
         Map<Integer, Integer> count = new HashMap<>();
        for (int a : arr)
            count.put(a, 1 + count.getOrDefault(a, 0));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparing(count::get));
        pq.addAll(count.keySet());
        while (k > 0)
            k -= count.get(pq.poll());
        return k < 0 ? pq.size() + 1 : pq.size();
    }
}
// Time Complexity -O(NLogN)
// Space Complexity : O(N)
