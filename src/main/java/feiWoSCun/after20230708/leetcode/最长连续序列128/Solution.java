package feiWoSCun.after20230708.leetcode.最长连续序列128;

import java.util.Arrays;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/12/12
 * @Email: 2825097536@qq.com
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = {1, 2, 3, 3, 3, 4, 4, 5, 6, 7, 8,9};
        int i = solution.longestConsecutive(ints);
        System.out.println(i);
    }

    //排序 去重 哈希表
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        Arrays.sort(nums);
        int pre = Integer.MIN_VALUE;
        int i = 0;
        int j = 1;
        int res = 1;
        while (j < nums.length) {
            int ans = 1;
            while (j < nums.length && nums[j] == nums[i] + 1) {
                ans++;
                while (j < nums.length - 1 && nums[j + 1] == nums[j]) {
                    j++;
                }
                i = j;
                j += 1;
            }
            res = Math.max(res, ans);
            i = j;
            j += 1;
        }
        return res;
    }
}
