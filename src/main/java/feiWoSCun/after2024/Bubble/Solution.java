package feiWoSCun.after2024.Bubble;

import java.util.Arrays;

/**
 * @author 28250
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.nextPermutation(new int[]{1, 3, 2});
    }

    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int i = nums.length - 2;
        while (i >= 0) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i] && nums[j] < min) {
                    min = nums[j];
                    index = j;
                }
            }
            if (index > 0) {
                nums[i] ^= nums[index];
                nums[index] ^= nums[i];
                nums[i] ^= nums[index];
                Arrays.sort(nums, i + 1, nums.length );
                return;
            }
            i--;
        }
        Arrays.sort(nums);
    }

    private void bubble(int[] arr, int start, int end) {
        int n = end;
        for (int i = start; i < n; i++) {
            for (int j = start; j < n - i + start; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换相邻元素
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}