package com.leetcode.Medium;

public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int prev = prices[0];

        for (int i=1; i<prices.length; i++) {
            int curr = prices[i];
            maxProfit += Math.max(0, curr - prev);
            prev = curr;
        }

        return maxProfit;
    }

}
