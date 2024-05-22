package feiWoSCun.after20230708.leetcode.回文子串020.动态规划;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/12/13
 * @Email: 2825097536@qq.com
 */
public class Solution {

    public static void main(String[] args) {

    }

    public int countSubstrings(String s) {
        char[] charArray = s.toCharArray();
        int ans = s.length();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = true;
            }
        }
        for (int i = 1; i < s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (charArray[i] == charArray[j]) {
                    if (i == j + 1) {
                        ans++;
                    } else {
                        dp[i][j] = dp[i - 1][j + 1];
                    }
                    if (dp[i][j]) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

}