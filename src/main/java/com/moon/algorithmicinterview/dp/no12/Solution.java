package com.moon.algorithmicinterview.dp.no12;

/**
 * 309. Best Time to Buy and Sell Stock with Cooldown
 * 思路：规定有三种状态，持有股票，卖出股票，休息（包括Cooldown）
 * 状态转移：
 * 持有股票：hold[i] = max{hold[i-1], rest[i-1] - price[i]} 可以
 * 卖出股票：sell[i] = hold[i-1] + price[i]
 * 休息：reset[i] = max{reset[i-1], sold[i-1]}
 *
 * @author Chanmoey
 * @date 2023/7/20
 */
class Solution {
    public int maxProfit(int[] prices) {
        int sell = 0;
        int reset = 0;
        int hold = Integer.MIN_VALUE;
        for (int price : prices) {
            int prevSell = sell;
            sell = hold + price;
            hold = Math.max(hold, reset - price);
            reset = Math.max(reset, prevSell);
        }

        return Math.max(sell, reset);
    }
}
