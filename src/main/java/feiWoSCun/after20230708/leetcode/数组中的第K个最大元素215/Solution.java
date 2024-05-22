package feiWoSCun.after20230708.leetcode.数组中的第K个最大元素215;

import feiWoSCun.ListNode;
import feiWoSCun.Util;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: {DATE}
 * @Email: 2825097536@qq.com
 */
class Solution {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int kthLargest = new Solution().findKthLargest(nums, 9);
        ListNode listNode = new ListNode(12);
        ListNode node=listNode;
        listNode.val=100;
        System.out.println(node.val+"   "+ listNode.val);
    }

    public int findKthLargest(int[] nums, int k) {

//快排
        int index = nums.length - 1;
        fast_sort(nums, 0, index, index - k + 1);
        return nums[index - k + 1];
    }

    private void fast_sort(int[] nums, int left, int right, int k) {
        if (left >= right) {
            return;
        }
        int temp = nums[left];
        int p1 = left;
        int p2 = right;
        while (p1 < p2) {
            while (nums[p2] >= temp && p1 < p2) {
                p2--;
            }
            if (nums[p2] < temp & p1 < p2) {
                nums[p1] = nums[p2];
                p1++;
            }
            while (nums[p1] <= temp && p1 < p2) {
                p1++;
            }
            if (nums[p1] > temp && p1 < p2) {
                nums[p2] = nums[p1];
                p2--;
            }
//swap
            nums[p1] = temp;
        }

        if (k >= p1 && k <= right)
            fast_sort(nums, p1 + 1, right, k);
        else
            fast_sort(nums, left, p1, k);
    }


}