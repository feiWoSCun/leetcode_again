package feiWoSCun.after20230708.nk.JZ63买卖股票的最好时机一;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/9/23
 * @Email: 2825097536@qq.com
 */

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param prices int整型一维数组
     * @return int整型
     */
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[][] dp = new int[length][2];
//0 有股份  1没有股份
        dp[0][0] = 0 - prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < length; i++) {

            dp[i][0] = Math.max(dp[i - 1][0], 0 - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
        }
        return dp[length - 1][1];
    }
}