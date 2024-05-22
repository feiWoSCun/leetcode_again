package feiWoSCun.after20230708.leetcode.跳跃游戏55;

import java.util.Arrays;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/12/24
 * @Email: 2825097536@qq.com
 */
class Solution {
    public static void main(String[] args) {
        int[] nums = {2,0,0};
        Solution solution = new Solution();
        boolean b = solution.canJump(nums);
        System.out.println(b);
    }

    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        return this.jump(nums, 0,new boolean[nums.length]);
    }
    private boolean jump(int[] nums, int index,boolean[] dp) {
        System.out.println(index);
        if(dp[index]){
            return false;
        }
        if (index >= nums.length - 1) {
            return true;
        }
        if(nums[index]==0){
            dp[index]=true;
            return false;
        }

        boolean res = false;
        for (int i = 1; i <= nums[index]; i++) {
            if (dp[index]){
                break;
            }
            res = jump(nums, index + i,dp);
            if (res) {
                break;
            }else {
                dp[index+i]=true;
            }
        }
        return res;
    }


}