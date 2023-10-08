package feiWoSCun.after20230708.数组中的第K个最大元素215;

import java.util.LinkedList;

/**
 * @description: 要超时
 * @author: feiWoSCun
 * @Time: 2023/7/8
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public static void main(String[] args) {
        LinkedList<Object> objects = new LinkedList<>();
       /* Solution solution = new Solution();
        int[] arr = new int[]{3};
        feiWoSCun.SortUtil.fastSort(arr, 0, arr.length - 1);
        int kthLargest = solution.findKthLargest(arr, 3);
        System.out.println(kthLargest);*/

        int[] arr = new int[]{3, 2, 3, 4, 5, 6, 76, 5, 4, 3, 67, 8, 7, 23, 15, 67};

        int[] ints = new Solution().quickSort2(arr, 0, arr.length - 1);
        System.out.println(ints);
    }

    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        int index = nums.length - k;
        int i = quickSort(nums, 0, length - 1);
        while (true) {
            if (i < index) {
                i = quickSort(nums, i + 1, length - 1);
            } else if (i > index) {
                i = quickSort(nums, 0, i - 1);
            } else {
                return nums[i];
            }
        }
    }

    public int quickSort(int[] nums, int left, int right) {
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
                while (nums[i] < temp && i < j) {
                    i++;
                }
                if (i < j) {
                    nums[j--] = nums[i];
                }
            }
            //swap
            nums[i] = temp;

        }
        return i;
    }

    public int[] quickSort2(int nums[], int left, int right) {
        int i = left;
        int j = right;
        int tempVar = nums[left];
        if (i < j) {
            while (i < j) {
                while (nums[j] <= tempVar && i < j) {
                    j--;
                }
                if (i < j) {
                    nums[i++] = nums[j];
                }
                while (nums[i] > tempVar && i < j) {
                    i++;
                }
                if (i < j) {
                    nums[j--] = nums[i];
                }
            }
            nums[i] = tempVar;
            quickSort2(nums, left, i - 1);
            quickSort2(nums, i + 1, right);
        }
        return nums;
    }

}
