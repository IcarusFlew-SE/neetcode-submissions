class Solution {
    public int maxProfit(int[] prices) {
        // iterate forward day (ith) - no backwards, find best buy first then best sell 
        // Minimize buy, maximize sell
        int min = prices[0];
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }
}
