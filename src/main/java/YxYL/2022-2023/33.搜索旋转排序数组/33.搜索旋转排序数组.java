/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {

    public static int search(int[] nums, int target) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                if(i == 0){
                    return 0;
                }
                res += i == 0 ? 1 : i;
            }
        }
        return res == 0 ? -1 : res;
    }
}
// @lc code=end
