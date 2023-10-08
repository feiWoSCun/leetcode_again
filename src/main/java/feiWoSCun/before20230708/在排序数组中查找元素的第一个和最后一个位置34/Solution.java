package feiWoSCun.before20230708.在排序数组中查找元素的第一个和最后一个位置34;

/**
 * 双指针
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 时间1 ms 击败 9.61% 内存44.3 MB 击败 93.9%
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] temp = {5, 7, 7, 8, 8, 10};
        int[] temp1 = {5, 7, 7, 8, 8, 10};
        int[] ints = solution.searchRange(temp1, 6);
        System.out.println(ints);
    }

    public int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        int[] ans = {-1, -1};
        for (int i = 0, j = length - 1; i < length; i++, j--) {
            if (nums[i] == target && ans[0] == -1) ans[0] = i;
            if (nums[j] == target && ans[1] == -1) ans[1] = j;
            if (ans[0] != -1 && ans[1] != -1) break;
        }
        return ans;
    }
}