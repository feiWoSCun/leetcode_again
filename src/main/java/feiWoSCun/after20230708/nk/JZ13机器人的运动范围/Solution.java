package feiWoSCun.after20230708.nk.JZ13机器人的运动范围;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/9/25
 * @Email: 2825097536@qq.com
 */

import java.util.*;

public class Solution {
    public int movingCount(int threshold, int rows, int cols) {
        boolean ans[][] = new boolean[rows][cols];

        int res = getNums(threshold, 0, 0, ans, rows, cols);

        return res;
    }


    private int getNums(int threshold, int rows, int cols, boolean[][] ans,
                        int rows1, int cols1) {
        if (calculateNums(cols, rows) > threshold || rows < 0 || rows >= rows1 || cols >= cols1 || cols < 0 ||
                ans[rows][cols]) {
            return 0;
        }
        ans[rows][cols] = true;
        return 1 + getNums(threshold, rows + 1, cols, ans, rows1, cols1) +
                getNums(threshold, rows - 1, cols, ans, rows1, cols1) +
                getNums(threshold, rows, cols + 1, ans, rows1, cols1) +
                getNums(threshold, rows, cols - 1, ans, rows1, cols1);

    }

    private int calculateNums(int rows, int cols) {
        int ans = 0;
        while (rows > 0) {
            ans += rows % 10;
            rows /= 10;
        }
        while (cols > 0) {
            ans += cols % 10;
            cols /= 10;
        }
        return ans;
    }

}

