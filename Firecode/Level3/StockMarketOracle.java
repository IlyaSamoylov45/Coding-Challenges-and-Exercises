/*
You've recently acquired market prediction superpowers that let you predict the closing stock price of a Acme Inc. 's stock a month into the future! To get the most out of this superpower, you need to write a method called maxProfit that takes in an array of integers representing the close out stock price on a given day. This method should return the maximum profit you can make out of trading Acme Inc.'s stock. There are a few limitations however :

1) You must sell your current holding before buying another - i.e. You may not buy and then buy again. It needs to be a buy - sell - buy - sell ... pattern.

2)  You may complete as many transactions as you like. You're using an awesome service like Robinhood, and so there are no transaction costs!

3) If you're enormously unlucky (or karma takes over) and no profit can be made, return 0.

Examples:

[50,100,20,80,20] => 110

[50,100] => 0

[50,100,50,100,50] => 100
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static int maxProfit(int[] a) {
    int total = 0;
    for(int i = 1; i < a.length; i++){
        if(a[i] > a[i-1]){
            total += a[i] - a[i-1];
        }
    }
    return total;

}
