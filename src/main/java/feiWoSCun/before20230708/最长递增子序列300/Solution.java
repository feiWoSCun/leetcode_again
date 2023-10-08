package feiWoSCun.before20230708.最长递增子序列300;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/4/9
 * @Email: 2825097536@qq.com
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        //用一个数组表示第i个元素的最长子序列
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxLen = dp[0];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    //更新
                    //状态转移方程
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}