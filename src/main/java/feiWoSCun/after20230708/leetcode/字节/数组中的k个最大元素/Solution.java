package feiWoSCun.after20230708.leetcode.字节.数组中的k个最大元素;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/12/3
 * @Email: 2825097536@qq.com
 */
public class Solution {
    private static int x=0;
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = {10,2,234,12,3432,3245,546, 2, 4, 3, 7, 6, 8, 4, 6, 7, 3, 2, 1};
        int kOfMax = solution.getKOfMax(ints, 3);
        System.out.println(kOfMax);
    }

    public int getKOfMax(int[] nums, int target) {
        sort(nums, target, 0, nums.length - 1);
        return nums[target];

    }

    private void sort(int[] nums, int k, int left, int right) {
        if (left >= right) {
            return;
        }
        System.out.println(++x);
        int l = left;
        int r = right;
        int temp = nums[left];
        while (l < r) {
            while (nums[r] <= temp && l < r) {
                r--;
            }
            if (nums[r] > temp && l < r) {
                nums[l] = nums[r];
                l++;
            }
            while (nums[l] >= temp && l < r) {
                l++;
            }
            if (nums[l] < temp && l < r) {
                nums[r] = nums[l];
            }
            //swap
            nums[l] = temp;
            sort(nums, k, left, l);
            if (k >= l + 1) {
                sort(nums, k, l + 1, right);
            }
        }


    }
}