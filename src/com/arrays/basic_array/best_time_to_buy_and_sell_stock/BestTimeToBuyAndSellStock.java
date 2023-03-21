package com.arrays.basic_array.best_time_to_buy_and_sell_stock;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, minPrice = Integer.MAX_VALUE, currentProfit;

        for (int i = 0; i < prices.length; i++) {
            // if price[i] < minPrice, and set minPrice to price[i]
            minPrice = Math.min(minPrice, prices[i]);
            // find the current profit for current price subtracted by minPrice
            currentProfit = prices[i] - minPrice;
            // if maxProfit < currentProfit, set maxProfit to currentProfit
            maxProfit = Math.max(maxProfit, currentProfit);
        }

        return maxProfit;
    }
}
