package feiWoSCun.after20230708.leetcode.字节;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * @description: 数组找最大数
 * @author: feiWoSCun
 * @Time: 2023/11/30
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr=new int[]{5,4};
        int i = new Solution().selectMax(arr, 54333);
        System.out.println(i);
    }

    public int selectMax(int[] nums, int target) {
        quickSort(nums,0,nums.length-1);
        Stack<Integer> stack = new Stack<>();
        while (target != 0) {
            stack.push(target % 10);
            target /= 10;
        }
        int ans = 0;
        int index=0;
        while (!stack.isEmpty()) {

            index+=1;
            int near = getNear(nums, stack.pop());
            if (near==-1&&index>=nums.length){
                return -1;
            }else {
                ans *= 10;
                ans+=near;
            }

        }
        return ans;
    }

    private void quickSort(int[] nums, int left, int right) {
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
        quickSort(nums, left, l);
        quickSort(nums, l + 1, right);
    }

    private int getNear(int[] nums, int tar) {
        if (tar > nums[nums.length - 1]) {
            return nums[nums.length - 1];
        }
        if (tar < nums[0]) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        int middle = 0;
        int ans = 0;
        while (l <= r) {
            middle = l + ((r - l) >> 1);
            if (nums[middle] == tar) {
                return tar;
            }
            if (nums[middle] > tar) {
                r = middle-1;
            }
            if (nums[middle] < tar) {
                ans = nums[middle];
                l = middle+1;
            }
        }
        return ans;
    }

}