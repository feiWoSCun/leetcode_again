package feiWoSCun.after20230708.nk.JZ59滑动窗口的最大值;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/9/5
 * @Email: 2825097536@qq.com
 */

import feiWoSCun.TreeNode;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.concurrent.CompletableFuture;


public class Solution {
    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] arr = {2, 3, 4, 2, 6, 2, 5, 1};
        int size = 3;

        ArrayList<Integer> arrayList = solution.maxInWindows(arr, 1);
        System.out.println(arrayList);
    }

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        if (num.length < size || size == 0) {
            return null;
        }

        ArrayList<Integer> arr = new ArrayList<>();
        int end = size - 1;
        int begin = 0;
        int preIndex = -1;
        while (end <= num.length - 1) {
            int ans = 0;
            if (preIndex != -1) {
                if (preIndex < begin) {
                    ans = getIndexMax(num, begin, end);
                } else {
                    ans = num[end] >= num[preIndex] ? end : preIndex;
                }
            } else {
                ans = getIndexMax(num, begin, end);
                preIndex = ans;
            }
            begin++;
            end++;
            arr.add((num[ans]));
        }
        // write code here
        return arr;
    }

    public int getIndexMax(int[] nums, int begin, int end) {
        int max = -10001;
        int index = -1;
        ;
        while (begin <= end) {
            if (max < nums[begin]) {
                max = nums[begin];
                index = begin;

            }
            begin++;
        }
        return index;
    }


}