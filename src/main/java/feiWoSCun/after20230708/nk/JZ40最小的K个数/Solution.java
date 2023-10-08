package feiWoSCun.after20230708.nk.JZ40最小的K个数;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/9/29
 * @Email: 2825097536@qq.com
 */

import java.util.*;


public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<Integer> arrayList = solution.GetLeastNumbers_Solution(new int[]{0, 1, 1, 1, 4, 5, 3, 7, 7, 8, 10, 2, 7, 8, 0, 5, 2, 16, 12, 1, 19, 15, 5, 18, 2, 2, 22, 15, 8, 22, 17, 6
                , 22, 6, 22, 26, 32, 8, 10, 11, 2, 26, 9, 12, 9, 7, 28, 33, 20, 7, 2, 17, 44, 3, 52, 27, 2, 23, 19, 56, 56, 58, 36, 31, 1, 19, 19, 6, 65, 49, 27, 63, 29, 1, 69, 47, 56, 61, 40, 43, 10, 71, 60, 66, 42, 44, 10, 12, 83,
                69, 73, 2, 65, 93, 92, 47, 35, 39, 13, 75}, 12);
        System.out.println(arrayList.toString());
    }


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param input int整型一维数组
     * @param k     int整型
     * @return int整型ArrayList
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        // write code here
        quick_sort(input, 0, input.length - 1, k);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }

    private void quick_sort(int[] nums, int left, int right, int k) {
        if (left >= right) {
            return;
        }
        int temp = nums[left];
        int r = right;
        int l = left;
        while (left < right) {
            while (nums[right] >= temp && left < right) {
                right--;
            }
            if (nums[right] < temp && left < right) {
                nums[left] = nums[right];
                left++;
            }
            while (nums[left] <= temp && left < right) {
                left++;
            }
            if (nums[left] > temp && left < right) {
                nums[right] = nums[left];
                right--;
            }
            //swap
            nums[left] = temp;
        }
        quick_sort(nums, l, left, k);
        //这一步很关键
        if (left >= k - 1) {
            return;
        }
        quick_sort(nums, left + 1, r, k);
    }

}