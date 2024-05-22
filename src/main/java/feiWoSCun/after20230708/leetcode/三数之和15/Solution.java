package feiWoSCun.after20230708.leetcode.三数之和15;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: {DATE}
 * @Email: 2825097536@qq.com
 */
class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = new Solution().threeSum(nums);
        System.out.println(lists);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        quick_sort(nums, 0, nums.length - 1);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            while (left < right) {
                int temp = nums[left] + nums[right] + nums[i];
                if (temp == 0) {
                    List<Integer> inRes = new ArrayList<>();
                    inRes.add(nums[left]);
                    inRes.add(nums[right]);
                    inRes.add(nums[i]);
                    res.add(inRes);
                    while (left < right && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (temp < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }

    void quick_sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int temp = nums[left];
        int p1 = left;
        int p2 = right;
        while (p1 < p2) {
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
        quick_sort(nums, left, p1);
        quick_sort(nums, p1 + 1, right);
    }
}
