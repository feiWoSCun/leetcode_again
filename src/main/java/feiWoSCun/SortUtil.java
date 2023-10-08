package feiWoSCun;

import java.util.Queue;

/**
 * @description: 快速排序
 * @author: feiWoSCun
 * @Time: 2023/7/8
 * @Email: 2825097536@qq.com
 */
public class SortUtil {

    public static void fastSort(int[] nums, int left, int right) {
        int i = left;
        int j = right;
        if (i < j) {
            int temp = nums[left];
            while (i < j) {
                while (nums[j] >= temp && i < j) {
                    j--;
                }
                if (i < j) {
                    nums[i++] = nums[j];
                }
                while (nums[i] <= temp && i < j) {
                    i++;
                }
                if (i < j) {
                    nums[j--] = nums[i];
                }
            }
            //swap

            nums[i] = temp;
        fastSort(nums, left, i - 1);
        fastSort(nums, i + 1, right);
    }
    }
}
