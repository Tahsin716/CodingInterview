package com.greedy.best_time_to_buy_and_sell_stock_ii;

public class BestTimeToBuyAndSellStock_II {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        // Any time the prices[i] > prices[i - 1], i.e, the price of the stock is greater than it was in previous day,
        // we will add prices[i] - prices[i - 1] to maxProfit
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        return maxProfit;
    }
}
