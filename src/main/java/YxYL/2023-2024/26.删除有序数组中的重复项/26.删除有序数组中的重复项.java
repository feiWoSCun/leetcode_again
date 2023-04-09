import java.io.IOError;

/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除有序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 1;
        for (int fast = 0; fast < nums.length - 1; fast++) {
            if (nums[fast] != nums[fast + 1]) {
                nums[slow] = nums[fast + 1];
                slow++;
            }
        }
        return slow;
    }
}
// @lc code=end
