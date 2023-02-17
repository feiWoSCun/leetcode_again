import java.io.IOError;
import java.util.Spliterator.OfPrimitive;

/*
 * @lc app=leetcode.cn id=977 lang=java
 *
 * [977] 有序数组的平方
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0;//定义左指针
        int right = nums.length - 1;//定义右指针
        int[] res = new int[nums.length];//定义返回结果
        int index = nums.length - 1;//定义返回结果的角标
        while (left <= right) {//双指针向中间逼近
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                //让最大值永远从上往下放，直到最后
                res[index--] = nums[left] * nums[left];
                left++;
            } else {
                res[index--] = nums[right] * nums[right];
                right--;
            }
        }

        return res;
    }
}
// @lc code=end
