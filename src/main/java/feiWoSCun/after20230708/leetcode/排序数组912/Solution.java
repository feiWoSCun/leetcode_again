package feiWoSCun.after20230708.leetcode.排序数组912;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: {DATE}
 * @Email: 2825097536@qq.com
 */
class Solution {

    public int[] sortArray(int[] nums) {
        sort_array(nums, 0, nums.length - 1);
        return nums;
    }

    void sort_array(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int temp = nums[left];
        int p1 = left;
        int p2 = right;
        while (p1 < p2) {
            //从右边开始
            while (nums[p2] >= temp && p1 < p2) {
                p2--;
            }
            if (nums[p2] < temp && p1 < p2) {
                nums[p1] = nums[p2];
                p1++;
            }
            while (nums[p1] <= temp && p1 < p2) {
                p1++;
            }
            if (nums[p1] > temp && p1 < p2) {
                nums[p2] = nums[p1];
                p2--;
            }
            //swap
            nums[p1] = temp;

        }
        sort_array(nums, left, p1);
        sort_array(nums, p1 + 1, right);
    }
}
