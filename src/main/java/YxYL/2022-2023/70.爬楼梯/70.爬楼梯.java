/*
 * @lc app=leetcode.cn id=70 lang=java
 *
    [70] 爬楼梯
    假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
    每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
    
    示例 1：
    输入：n = 2
    输出：2
    解释：有两种方法可以爬到楼顶。
    1. 1 阶 + 1 阶
    2. 2 阶

    示例 2：
    输入：n = 3
    输出：3
    解释：有三种方法可以爬到楼顶。
    1. 1 阶 + 1 阶 + 1 阶
    2. 1 阶 + 2 阶
    3. 2 阶 + 1 阶

 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 1;
        ans[1] = 1;

        for (int i = 2; i <=n; i++) {
            ans[i] = ans[i - 1] + ans[i - 2];
        }
        //斐波那契数列
        //第n层需要的种数 = 第n-1层需要的种数 + 第n-2层需要的种数
        return ans[n];
    }
}
// @lc code=end
