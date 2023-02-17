import javax.swing.text.html.HTMLDocument.HTMLReader.HiddenAction;

/*
 * @lc app=leetcode.cn id=11 lang=java
 * 
 * 输入：[1,8,6,2,5,4,8,3,7]
    输出：49 
    解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
    示例 2：

    输入：height = [1,1]
    输出：1 
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        // 返回最大体积
        int maxV = -1;
        // 体积中间变量
        int V;
        // 左指针
        int left = 0;
        // 右指针
        int right = height.length - 1;
        // 左指针最大高度
        int maxLeft = -1;
        // 右指针最大高度
        int maxRight = -1;
        // 开始双指针遍历
        while (left < right) {
            // 记录一次遍历的计算出来的体积
            V = (right - left) * Math.min(height[left], height[right]);
            // 如果上一步计算出来体积是比最大的maxV大的话，就update
            if (V > maxV) {
                maxV = V;
            }
            // 如果右边的高度>左边的高度
            if (height[left] < height[right]) {
                // 这里跳过所有
                while (height[left] <= maxLeft && left < right) {
                    left++;
                }
                // 这里退出循环：说明原来的maxLeft已经比现在遍历的时候的left指针小了，maxLeft需要update
                // update最高值
                maxLeft = height[left];
            } else {
                // 这里跟上面一样
                while (height[right] <= maxRight && left < right) {
                    right--;
                }
                maxRight = height[right];
            }
        }
        return maxV;
    }
}
// @lc code=end
