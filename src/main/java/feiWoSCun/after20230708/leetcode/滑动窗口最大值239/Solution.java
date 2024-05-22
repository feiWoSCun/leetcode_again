package feiWoSCun.after20230708.leetcode.滑动窗口最大值239;

import java.util.Arrays;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/12/14
 * @Email: 2825097536@qq.com
 */class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] res = new int[nums.length - k + 1];
        int l = 0;
        int r = k - 1;
        int index = -1;
        int count = 0;
        while (r < nums.length) {
            if (index<=r&&index>=l&&nums[r]>nums[index]) {
                index = r;
            }
            index=findMaxIndex(nums,l,r);
            res[count] = nums[index];
            r++;
            l++;
            count++;
        }

        return res;
    }


    private int findMaxIndex(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }
        if (left == right) {
            return left;
        }
        int index = left;
        int max = nums[left];
        while (left <= right) {
            if (nums[left] > max) {
                index = left;
                max = nums[left];
            }
            left++;
        }
        return index;
    }
}