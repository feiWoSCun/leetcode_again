package feiWoSCun.after2024.hot239;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2024/1/28
 * @Email: 2825097536@qq.com
 */
class Solution {
    public static void main(String[] args) {
        int[] nums = {9,10,9,-7,-4,-8,2,-6};
        Solution solution = new Solution();
        int k=5;
        solution.maxSlidingWindow(nums,k);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (k == 1 || len == 1) {
            return nums;
        }

        //使用双端队列维护最大值
        Deque<Integer> dq = new LinkedList<>();
        int l = 1 - k;
        int r = 0;

        int[] res = new int[len - k + 1];
        while (r < len) {
            //越界
            if (l>0&&nums[l - 1] == dq.peekFirst()) {
                dq.removeFirst();
            }
            //维护一个最大值
            while (!dq.isEmpty()&&nums[r] > dq.peekLast()) {
                dq.pollLast();
            }
            dq.offerLast(nums[r]);
            if(l>=0) {
                res[l] = dq.peekFirst();
            }
            l++;
            r++;
        }
        return res;
    }
}
