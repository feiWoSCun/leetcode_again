package feiWoSCun.after20230708.leetcode.数组中的第K个最大元素215;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/7/30
 * @Email: 2825097536@qq.com
 */

class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        // 当k=1时表第一大元素，在数组中下标为0，需要减一
        return QS(nums, 0, nums.length - 1, k - 1);
    }
    // 快速排序
    private int QS(int[] nums, int begin, int end, int k) {
        if (begin > end) {
            return nums[k];
        }
        int lt = begin;
        int gt = end;
        int sen = nums[begin];
        while (lt != gt) {
            // 单调递减
            while (gt > lt && nums[gt] <= sen) {
                --gt;
            }
            while (lt < gt && nums[lt] >= sen) {
                ++lt;
            }
            if (gt > lt) {
                int tmp = nums[lt];
                nums[lt] = nums[gt];
                nums[gt] = tmp;
            }
        }
        //交换元素
        nums[begin] = nums[lt];
        nums[lt] = sen;

        // 区分元素K所在区间
        if (k >= begin && k <= lt - 1) {
            return QS(nums, begin, lt - 1, k);
        } else {
            return QS(nums, lt + 1, end, k);
        }
    }
}