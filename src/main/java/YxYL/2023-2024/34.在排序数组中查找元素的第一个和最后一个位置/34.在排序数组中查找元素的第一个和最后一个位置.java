package 未完成;

import java.nio.ReadOnlyBufferException;

import javax.lang.model.element.Element;
import javax.swing.UIClientPropertyKey;
import javax.swing.text.TableView.TableRow;

/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftBoard = findLeftBoard(nums, target);
        int rightBoard = findRightBoard(nums, target);
        if (leftBoard == -2 || rightBoard == -2)
            return new int[] { -1, -1 };
        if (rightBoard - leftBoard > 1)
            return new int[] { leftBoard + 1, rightBoard - 1 };

        return new int[] { -1, -1 };
    }

    public int findRightBoard(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int rightBoard = -2;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
                rightBoard = left;
            }
        }
        return rightBoard;

    }

    public int findLeftBoard(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int LeftBoard = -2;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (nums[mid] >= target) {
                right = mid - 1;
                LeftBoard = right;
            } else {
                left = mid + 1;
            }
        }
        return LeftBoard;
    }
}
// @lc code=end
