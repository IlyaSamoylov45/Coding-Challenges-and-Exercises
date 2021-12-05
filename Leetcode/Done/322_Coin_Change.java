// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
//
// Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
//
// You may assume that you have an infinite number of each kind of coin.
//
//
//
// Example 1:
//
// Input: coins = [1,2,5], amount = 11
// Output: 3
// Explanation: 11 = 5 + 5 + 1
// Example 2:
//
// Input: coins = [2], amount = 3
// Output: -1
// Example 3:
//
// Input: coins = [1], amount = 0
// Output: 0
// Example 4:
//
// Input: coins = [1], amount = 1
// Output: 1
// Example 5:
//
// Input: coins = [1], amount = 2
// Output: 2
//
//
// Constraints:
//
// 1 <= coins.length <= 12
// 1 <= coins[i] <= 2^31 - 1
// 0 <= amount <= 10^4





class Solution {
    public int coinChange(int[] coins, int amount) {
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int remainder, int[] count){
        if(remainder < 0){
            return -1;
        }
        if(remainder == 0){
            return 0;
        }
        if(count[remainder - 1] != 0){
            return count[remainder - 1];
        }
        int min = Integer.MAX_VALUE;
        for(int coin : coins){
            int result = coinChange(coins, remainder - coin, count);
            if(result >= 0 && result < min){
                min = 1 + result;
            }
        }
        count[remainder - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[remainder - 1];
    }

}
// Time : O(N * S)
// Space : O(S)






class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dps = new int[amount + 1];
        Arrays.fill(dps, amount + 1);
        dps[0] = 0;
        for(int coin : coins){
            for(int i = coin; i < dps.length; i++){
                dps[i] = Math.min(dps[i - coin] + 1, dps[i]);
            }
        }
        return dps[amount] < amount + 1 ? dps[amount] : -1;
    }

}
// Time : O(N * S)
// Time : O(S)
