/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int slow = 0;
        int subLength = 0;
        int sum = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            sum += nums[fast];
            while (sum >= target) {
                subLength = fast - slow + 1;
                res = res > subLength ? subLength : res;
                sum -= nums[slow++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
// @lc code=end
