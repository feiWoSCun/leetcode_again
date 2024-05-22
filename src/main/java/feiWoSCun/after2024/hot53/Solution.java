package feiWoSCun.after2024.hot53;

import java.util.ArrayList;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2024/1/29
 * @Email: 2825097536@qq.com
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        int i = solution.maxSubArray(nums);
        System.out.println(i);
        ArrayList<int[]> objects = new ArrayList<>();
        int[][] array = objects.toArray(new int[0][0]);
    }

    public int maxSubArray(int[] nums) {
        //使用dp[i]表以i结尾的字符的最大值
        int max = 0;
        int[] dp = new int[nums.length];
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max += nums[i];
            int num = 0;
            res = Math.max(max, res);
            for (int j = 0; j < i; j++) {
                num += nums[j];
                res = Math.max(res, max - num);
            }
            System.out.println(res);
        }
        return res;
    }
}
