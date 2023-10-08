package feiWoSCun.after20230708.nk.JZ3数组中重复的数字;

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
        int i = solution.duplicate(new int[]{2, 1, 3,2});
        System.out.println(i);
    }

    int res = -1;

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param numbers int整型一维数组
     * @return int整型
     */
     public int duplicate (int[] numbers) {
        if (numbers.length <= 1) {
            return -1;
        }
        // write code here
        merge(numbers,0,numbers.length-1);
        return res;
    }
    public void merge(int[] nums, int left, int right) {
        if (left >= right) {
            return ;
        }
        int mid = left + ((right - left) >> 1);
        merge(nums, left, mid);
        merge(nums, mid + 1, right);
        if(res==-1){
        quick_sort(nums, left, right, mid);
        }else {
            return;
        }


    }
    private void quick_sort(int[] nums, int left, int right, int mid) {
        int[] temp = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <=right) {
            if (nums[p2] < nums[p1]) {
                temp[i++] = nums[p2++];
            }
           else if (nums[p1] < nums[p2]) {
                temp[i++] = nums[p1++];
            } else {
                res = nums[p1];
                return;
            }
        }
        while (p1 <= mid) {
            temp[i++] = nums[p1++];
        }
        while (p2 <= right) {
            temp[i++] = nums[p2++];
        }
        for (int j = 0; j < temp.length; j++) {
            nums[left + j] = temp[j];
        }
    }
}