package feiWoSCun.after20230708.leetcode.岛屿数量200;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/12/10
 * @Email: 2825097536@qq.com
 */
class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    traverse(grid, i, j);
                    ans += 1;
                }
            }
        }
        return ans;
    }

    private void traverse(char[][] grid, int w, int d) {


        if (!ifIn(grid, d, w) || grid[d][w] == '0') {
            return;
        }
        grid[d][w] = '2';
        traverse(grid, w, d - 1);
        traverse(grid, w, d + 1);
        traverse(grid, w + 1, d);
        traverse(grid, w - 1, d);
    }

    private boolean ifIn(char[][] grid, int depth, int width) {
        int d = grid.length - 1;
        int w = grid[0].length - 1;
        return 0 <= depth && depth <= d && width > 0 && width <= w;
    }
}