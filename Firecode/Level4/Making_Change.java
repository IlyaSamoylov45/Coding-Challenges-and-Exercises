// Given an integer array containing the available denominations of coins in descending order, write a method to compute the number of possible ways of representing a monetary amount in cents.
//  For simplicity, assume that there are an infinite number of coins available for each coin denomination in the array.
//
// Examples:
//
// makeChange({25,10,5,1},10) ==> 4



// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static int makeChange(int[] coins, int amount) {
    if(amount <= 0){
        return 0;
    }
    int[] amounts = new int[amount + 1];
    amounts[0] = 1;
    for(int i = 0; i < coins.length; i++){
        int coin = coins[i] ;
        for(int j = coin; j < amounts.length; j++){
            amounts[j] += amounts[j-coin];
        }
    }
    return amounts[amount];
}
