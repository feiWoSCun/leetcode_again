package feiWoSCun.after20230708.leetcode.三数之和15.second;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/12/13
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public static void main(String[] args) {
        int[] ints = {-2, 0, 1, 1, 2};
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.threeSum(ints);

    }

    public List<List<Integer>> threeSum(int[] nums) {
        quick_sort(nums, 0, nums.length - 1);
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        for (int i = 2; i < nums.length; i++) {
            int l = 0;
            int r = i - 1;
            if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                continue;
            }
/**    记一次错误，不能写成i-1；因为是向前遍历的
 *     if (i<nums.length-1&&nums[i] == nums[i - 1]) {
 *                 continue;
 *             }
 */


            while (l < r) {
                int sum = nums[l] + nums[r] + nums[i];
                if (sum == 0) {
                    ArrayList<Integer> inRes = new ArrayList<>();
                    inRes.add(nums[l]);
                    inRes.add(nums[r]);
                    inRes.add(nums[i]);
                    res.add(inRes);
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (r > l && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }


            }
        }
        return res;
    }

    private void quick_sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left;
        int r = right;
        int temp = nums[left];
        while (l < r) {
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