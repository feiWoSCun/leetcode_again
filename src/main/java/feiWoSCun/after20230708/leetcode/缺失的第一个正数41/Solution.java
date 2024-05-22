package feiWoSCun.after20230708.leetcode.缺失的第一个正数41;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/12/20
 * @Email: 2825097536@qq.com
 */
class Solution {
    private int nextExpectNum = 1;

    public static void main(String[] args) {

        String fileName = "E:\\pre\\pre_project\\javaStudy\\demoForStudy\\demoForStudy\\leetcode_again\\src\\array.txt"; // 替换为你的txt文件路径
        List<Integer> array = null;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine(); // 读取文件内容
            String[] elements = line.split(","); // 按逗号分割字符串

            array = new ArrayList<>();
            for (String element : elements) {
                int value = Integer.parseInt(element.trim()); // 转换为整数
                array.add(value);
            }

        } catch (IOException e) {
            System.err.println("读取文件时出错: " + e.getMessage());
        }


        int[] arr = new int[array.size()];
        for (int i = 0; i < array.size(); i++) {
            arr[i] = array.get(i);
        }
        long now = System.currentTimeMillis();
        Solution solution = new Solution();
        int i = solution.firstMissingPositive(arr);
        long l = System.currentTimeMillis();
        System.out.println(i);
        System.out.println(l - now);
        System.out.println("最终经历: "+solution.count);
    }

    public int firstMissingPositive(int[] nums) {
        if (nums.length == 1) {
            return nums[0] == 1 ? 2 : 1;
        }
        sort(nums, 0, nums.length - 1);
        if (!ifReturn) {
            return needReturn == 1 ? 1 : needReturn + 1;
        }
        return needReturn;
    }

    boolean ifReturn = false;
    int needReturn = 1;
    int count = 0;

    private void sort(int[] nums, int left, int right) {
                  count++;
        if (right <= left) {
            if (right == nums.length - 1) {
                needReturn += 1;
            }
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
        sort(nums, left, l);
        if (ifReturn) {
            return;
        }
        int tempL = left;
        int TempR = l;
        int expectNum = nextExpectNum;

        while (tempL <= TempR) {
            if (nums[tempL] <= expectNum) {
                expectNum = nums[tempL] <= 0 ? 1 : nums[tempL] < expectNum ? expectNum : expectNum + 1;
                needReturn = expectNum;
            } else {
                System.out.println("找到target"+count);
                ifReturn = true;
                needReturn = expectNum;
                return;
            }
            tempL++;
        }
        nextExpectNum = expectNum;
        sort(nums, l + 1, right);
    }
}
