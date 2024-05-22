package feiWoSCun.after20230708.leetcode.和为k的子数组;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/12/13
 * @Email: 2825097536@qq.com
 */
public class Solution {


    public int subarraySum(int[] nums, int k) {
        quick_sort(nums, 0, nums.length - 1);

        int l = 0;
        int temp = nums[l];
        int r = l;
        return 1;

    }

    private void quick_sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left;
        int r = right;
        int temp = nums[left];
        while (left < right) {
            while (nums[r] >= temp && l < r) {
                r--;
            }
            if (nums[r] < temp && l < r) {
                nums[l] = nums[r];
                l++;
            }
            while (nums[l] <= temp && l < r) {
                l++;
            }
            if (nums[l] > temp && l < r) {
                nums[r] = nums[l];
                r--;
            }
            //swap
            nums[l] = temp;
        }
        quick_sort(nums, left, l);
        quick_sort(nums, l + 1, right);
    }

}