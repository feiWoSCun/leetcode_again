package feiWoSCun.after20230708.nk.JZ46把数字翻译成字符串;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/9/23
 * @Email: 2825097536@qq.com
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int solve = solution.solve("72910721221427251718216239162221131917242");
    }


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 解码
     * @param nums string字符串 数字串
     * @return int整型
     */
    public int solve(String nums) {
        if("0".equals(nums)){
            return 0;
        }
        if("10".equals(nums)||"20".equals(nums)){
            return 1;
        }
        if (nums.length() <= 1) {
            return nums.length();
        }
        int[] dp = new int[nums.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= nums.length(); i++) {
            char c = nums.charAt(i - 1);
            if ((c == '0' && !(nums.charAt(i - 2) == '1' || nums.charAt(i - 2) == '2'))) {
                return 0;
            }
            if ((nums.charAt(i - 2) == '1' && c != '0') ||
                    (nums.charAt(i - 2) == '2' && (c-'0'>0)&&c-'6'<=0)) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[nums.length()];
    }
}

