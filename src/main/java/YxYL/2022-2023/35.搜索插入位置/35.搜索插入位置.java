import java.io.IOException;
import java.util.zip.GZIPInputStream;

import javax.lang.model.element.Element;

/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return right + 1;
    }
}
// @lc code=end
