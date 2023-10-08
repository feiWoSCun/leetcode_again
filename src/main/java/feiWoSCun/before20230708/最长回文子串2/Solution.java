package feiWoSCun.before20230708.最长回文子串2;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/4/9
 * @Email: 2825097536@qq.com
 */
class Solution {
    public String longestPalindrome(String s) {

        int left = 0;
        int right = 0;
        int maxLength = 1;
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (i - j + 1 > maxLength) {
                        left = j;
                        right = i;
                        maxLength = i - j + 1;
                    }

                }
            }
        }
        return s.substring(left, right + 1);

    }
}