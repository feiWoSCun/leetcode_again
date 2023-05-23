package feiWoSCun.跳跃游戏Ⅱ45;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/4/10
 * @Email: 2825097536@qq.com
 */
class Solution {
    public int jump(int[] nums) {
        int length = nums.length;
        int border = 0;
        int maxPosition = 0;
        int step = 0;
        //有点没太懂这个 范围的问题
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == border) {
                step += 1;
                border = maxPosition;
            }

        }


        return step;
    }
}