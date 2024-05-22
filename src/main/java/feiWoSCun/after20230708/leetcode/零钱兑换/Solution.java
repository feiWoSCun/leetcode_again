package feiWoSCun.after20230708.leetcode.零钱兑换;

import java.util.*;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/12/24
 * @Email: 2825097536@qq.com
 */
class Solution {
    public static void main(String[] args) {
        int[] nums = {2, 34, 13, 5, 6};
        Solution solution = new Solution();
        solution.coinChange(nums,45);

    }
    public int coinChange(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }
        int level=0;
        Set<Integer> has=new HashSet<>();
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(amount);
        quick_sort(coins,0,coins.length-1);
        while(!queue.isEmpty()){
            int len=queue.size();
            level++;
            for(int i=0;i<len;i++){
                int m=queue.poll();
                for(int coin:coins){
                    int temp=m-coin;
                    if(temp<0){
                        continue;
                    }
                    if(temp==0){
                        return level;
                    }
                    if(!has.contains(temp)){
                        queue.offer(temp);
                    }
                    has.add(temp);
                }
            }
        }
        return -1;
    }
    private void quick_sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left;
        int r = right;
        int temp = nums[left];
        while (l < r) {
            while (nums[r] <= temp && l < r) {
                r--;
            }
            if (nums[r] > temp && l < r) {
                nums[l] = nums[r];
                l++;
            }
            while (nums[l] >= temp && l < r) {
                l++;
            }
            if (nums[l] < temp && l < r) {
                nums[r] = nums[l];
                r--;
            }
            //swap
            nums[l] = temp;
        }
        quick_sort(nums, left, l);
        quick_sort(nums, l + 1, right);
    }
}