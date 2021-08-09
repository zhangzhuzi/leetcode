package com.leetcode.greedy;

/**
 * @description: MaxProfit
 * @date: 2021/8/9 9:44
 * @author: zsz
 * 股票的最大利润：7 1 5 3 6 4
 * 可以有一次买入和一次卖出，买入必须在前。求最大收益。
 */
public class MaxProfit {
    /*// 运行超时
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (prices.length == 0) {
            return 0;
        }

        int profit = 0;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (prices[j] - prices[i] > profit) {
                    profit = prices[j] - prices[i];
                }
            }
        }
        return profit;
    }*/

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int in = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < in) {
                in = prices[i];
            }
            if (prices[i] - in > profit) {
                profit = prices[i] - in;
            }
        }
        return profit;
    }
}
