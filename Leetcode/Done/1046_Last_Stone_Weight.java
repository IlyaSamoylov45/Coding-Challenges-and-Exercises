// We have a collection of stones, each stone has a positive integer weight.
//
// Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
//
// If x == y, both stones are totally destroyed;
// If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
// At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
//
//
//
// Example 1:
//
// Input: [2,7,4,1,8,1]
// Output: 1
// Explanation:
// We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
// we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
// we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
// we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
//
//
// Note:
//
// 1 <= stones.length <= 30
// 1 <= stones[i] <= 1000







class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        for(int stone : stones){
            queue.offer(stone);
        }
        int remainder = 0;
        while(queue.size() > 1){
            remainder = queue.remove() - queue.remove();
            queue.offer(remainder);
        }
        return queue.remove();
    }
}
// Time : O(NLogN)
// Space : O(N)







class Solution {
    public int lastStoneWeight(int[] stones) {
        int[] bucket = new int[1000];
        for(int stone : stones){
            bucket[stone - 1]++;
        }
        int i = bucket.length - 1;
        while(i >= 0){
            if(bucket[i] == 0){
                i--;
            }else{
                bucket[i] %= 2;
                if(bucket[i] != 0){
                    int j = i - 1;
                    while(j >= 0 && bucket[j] == 0){
                        j--;
                    }
                    if(j < 0 || bucket[j] == 0){
                        return i + 1;
                    }
                    int remainder = i - j;
                    if(remainder > 0){
                        bucket[remainder - 1]++;
                    }
                    bucket[i]--;
                    bucket[j]--;
                }
            }
        }
        return 0;
    }
}
// Time : O(N)
// Space : O(N)







class Solution {
    public int lastStoneWeight(int[] stones) {
        int[] bucket = new int[1001];
        for(int stone : stones){
            bucket[stone]++;
        }
        int i = bucket.length - 1;
        int j;
        while(i > 0) {
          if(bucket[i] == 0) {
            i--;
          } else {
            bucket[i] = bucket[i] % 2;
            if(bucket[i] != 0) {
              j = i-1;
              while(j > 0 && bucket[j] == 0)
                j--;
              if(j == 0){
                return i;
              }
              bucket[i - j]++;
              bucket[j]--;
              i--;
            }
          }
        }
        return 0;
    }
}
// Time : O(N)
// Space : O(N)
