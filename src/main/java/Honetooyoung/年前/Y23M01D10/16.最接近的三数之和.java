package Honetooyoung.年前.Y23M01D10;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] nums = {6, 2, 3, 5, 8, 9, 4, 11, 17, 14};
        System.out.println(new Solution().threeSumClosest(nums, 20));
    }

    /*
    * 给你一个长度为 n 的整数数组nums和 一个目标值target。请你从 nums 中选出三个整数，使它们的和与target最接近。

    返回这三个数的和。

    假定每组输入只存在恰好一个解。*/
    public int threeSumClosest(int[] nums, int target) {
        //排序
        Arrays.sort(nums);
        //声明答案变量
        int ans = nums[0] + nums[1] + nums[2];
        int len = nums.length;
        //最大值都小于target 直接返回
        if (nums[len - 1] + nums[len - 2] + nums[len - 3] < target)
            return nums[len - 1] + nums[len - 2] + nums[len - 3];
        //最小值都大于target 直接返回
        if (ans > target)
            return ans;
        else {
            //双指针循环
            for (int i = 0; i < len - 2; i++) {
                int left = i + 1, right = len - 1;
                while (left != right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    ans = Math.abs(ans - target) < Math.abs(sum - target) ? ans : sum;
                    if (sum < target)
                        left++;
                    else if (sum > target)
                        right--;
                    else {
                        ans = target;
                        break;
                    }
                }
                if (ans == target) break;
            }
        }
        return ans;
    }
}