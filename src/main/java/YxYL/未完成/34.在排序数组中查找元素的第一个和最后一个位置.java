package 未完成;
import javax.lang.model.element.Element;
import javax.swing.text.TableView.TableRow;

/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = { -1, -1 };
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (nums[mid] <= target) {
                res[0] = mid - 1;
                left = mid + 1;
            } else if (nums[mid] >= target) {
                res[1] = mid - 1;
                right = mid - 1;
            } else {
                return res;
            }
        }
        return res;

    }
}
// @lc code=end
