// Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
//
// For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
//
// Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].





class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] values = new int[T.length];
        for(int i = T.length - 2; i >= 0; i--){
            int curr = T[i];
            int j = i + 1;
            while(j < T.length && T[j] <= curr && values[j] != 0){
                j += values[j];
            }
            if(T[j] > T[i]){
                values[i] = j - i;
            }
            //else{
            //    values[i] = 0;
            //}
        }
        return values;
    }
}
// Time : O(N)
// Space : O(W)






class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] values = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = T.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && T[i] >= T[stack.peek()]){
                stack.pop();
            }
            values[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return values;
    }
}
// Time : O(N)
// Space : O(W)
