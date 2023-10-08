package feiWoSCun.before20230708.搜索二维矩阵Ⅱ240;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/4/9
 * @Email: 2825097536@qq.com
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int r = 0, c = n - 1;
        while (r < m && c >= 0) {
            if (matrix[r][c] < target) {
                r++;
            } else if (matrix[r][c] > target) {
                c--;
            } else {
                return true;
            }
        }
        return false;
    }
}
