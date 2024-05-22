package feiWoSCun.after20230708.leetcode.最长公共子序列1143;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: {DATE}
 * @Email: 2825097536@qq.com
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= chars1.length; i++) {
            char c = chars1[i - 1];
            for (int j = 1; j <= chars2.length; j++) {
                char ch = chars2[j - 1];
                if (c == ch) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }

        }
        return dp[m][n];
    }
}