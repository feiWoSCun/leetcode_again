package feiWoSCun.after2024.买卖股票3;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2024/1/16
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(Integer.valueOf('a'));

    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        //定义状态
        //0什么都不做
        //1 第一次买股票
        //2 第一次卖股票
        //3 第二次买股票
        //4 第二次卖股票
        int status = 5;
        int[][] dp = new int[len][status];
        //初始化
        int pri_money = prices[0];
        dp[0][1] = -pri_money;
        dp[0][3] = -pri_money;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < status; j++) {
                if (j == 0) {
                    dp[i][0] = dp[i - 1][0];
                } else if (j % 2 == 0) {
                    //卖股
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
                } else {
                    //买股
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                }
            }
        }
        return dp[len - 1][status - 1];
    }
}