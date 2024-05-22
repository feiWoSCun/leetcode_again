package feiWoSCun.after20230708.leetcode.轮转数组189;

import java.util.concurrent.CountDownLatch;
import java.util.stream.Stream;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/12/19
 * @Email: 2825097536@qq.com
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{-1,-100,3,99};
        solution.rotate(nums, 2);
        for (int num : nums) {
            System.out.print(num);
        }
    }

    public void rotate(int[] nums, int k) {
        if (k == 0) {
            return;
        }

        //计算出每个元素的下标
        int maxIndex = nums.length;
        int count = maxIndex-1;
        int replace = nums[count];
        int l=count;
        while (count >= 0) {
            int index = (l + k) % maxIndex;
            int temp=nums[index];
            nums[index] = replace;
            replace = temp;
            l=index;
            count--;
        }


    }
}