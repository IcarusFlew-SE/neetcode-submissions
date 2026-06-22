class Solution {
    public int maxProfit(int[] prices) {
        // iterate forward day (ith) - no backwards, find best buy first then best sell 
        // Minimize buy, maximize sell
        int min = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) { // Start from next element
            if (prices[i] < min) min = prices[i];
            profit = Math.max(profit, prices[i] - min);
        }
        if (profit < 0) return 0;
        return profit;
    }
}
