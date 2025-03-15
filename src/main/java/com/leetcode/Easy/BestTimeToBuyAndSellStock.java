package com.leetcode.Easy;

public class BestTimeToBuyAndSellStock {

    /**
     * Function to calculate the maximum profit that can be achieved from a single stock transaction.
     * The goal is to buy the stock on one day and sell it on another future day, maximizing the profit.
     *
     * @param prices an array where prices[i] represents the price of the stock on the i-th day.
     * @return the maximum profit achievable from a single transaction, or 0 if no profit is possible.
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;  // To store the maximum profit we can achieve
        int minPrice = Integer.MAX_VALUE;  // To store the minimum price encountered so far

        // Loop through the prices array
        for (int p : prices) {
            // Update the minimum price if the current price is lower than the previous minimum
            minPrice = Math.min(minPrice, p);

            // Calculate the potential profit if we sold the stock at the current price
            maxProfit = Math.max(maxProfit, p - minPrice);
        }

        // Return the maximum profit
        return maxProfit;
    }
}
