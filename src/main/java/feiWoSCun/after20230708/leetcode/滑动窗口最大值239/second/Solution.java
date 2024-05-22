package feiWoSCun.after20230708.leetcode.滑动窗口最大值239.second;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/12/15
 * @Email: 2825097536@qq.com
 */
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public static void main(String[] args) {
        int x='a';
        int y='A';
        int z='Z';
        int m='z';
        System.out.println("a="+x);
        System.out.println("A="+y);
        System.out.println("Z="+z);
        System.out.println("z="+m);
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 && k == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        for (int j = 0, i = 1 - k; j < nums.length; j++, i++) {
            if (i > 0 && nums[i - 1] == queue.peekFirst()) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && queue.peekLast() < nums[j]) {
                queue.pollLast();
            }
            queue.offerLast(nums[j]);
            if (i >= 0) {
                res[i] = queue.peekFirst();
            }
            for (Integer m : queue) {
                System.out.print(m+" ");
            }
            System.out.println("");
        }

        return res;
    }
}
