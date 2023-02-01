package Honetooyoung.大二下.买卖股票的最佳时机II122;

class Solution {
    /*给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。

在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。

返回 你能获得的 最大 利润 。*/
    public static void main(String[] args) {
        int[] prices={7,1,5,3,6,4};
        System.out.println(new Solution().maxProfit2(prices));
    }
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // 0：持有现金
        // 1：持有股票
        // 状态转移：0 → 1 → 0 → 1 → 0 → 1 → 0
        int[][] dp = new int[len][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < len; i++) {
            // 这两行调换顺序也是可以的
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }
    /*不管如何，只要第i+1天大于第i天就进行交易（因为可以当天卖出，当天买入）*/
    public int maxProfit2(int[] prices) {
        int profit=0;
        for (int i = 1; i < prices.length; i++) {
            profit+=prices[i]>prices[i-1]?prices[i]-prices[i-1]:0;
        }
        return profit;
    }
}