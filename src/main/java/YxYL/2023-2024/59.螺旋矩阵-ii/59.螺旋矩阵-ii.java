/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int res[][] = new int[n][n];// 结果集
        int start = 0;// 起点索引
        int count = 1;// 计数
        int i, j;// 坐标

        int loop = 0;

        while (loop++ < n / 2) {
            // turn right
            for (j = start; j < n - loop; j++) {
                res[start][j] = count++;
            }

            // turn down
            for (i = start; i < n - loop; i++) {
                res[i][j] = count++;
            }

            // turn left
            for (; j >= loop; j--) {
                res[i][j] = count++;
            }

            // turn up
            for (; i >= loop; i--) {
                res[i][j] = count++;
            }
            start++;
        }

        if (n % 2 == 1)
            res[start][start] = count;

        return res;
    }
}
// @lc code=end
