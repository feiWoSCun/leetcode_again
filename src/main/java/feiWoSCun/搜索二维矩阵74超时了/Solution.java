package feiWoSCun.搜索二维矩阵74超时了;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/3/24
 * @Email: 2825097536@qq.com
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

         int[][] matrix={{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        //int[][] matrix = {{1, 3}};

        boolean b = solution.searchMatrix(matrix, 1);
        System.out.println(b);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix[0][matrix[0].length - 1] == target) {
            return true;
        }
        return judgeIsTrue(matrix, 0, matrix[0].length - 1, target, false);
    }

    public boolean judgeIsTrue(int[][] matrix, int raw, int column, int target, boolean res) {
        if (res == true) {
            return res;
        }
        /*if (raw >= matrix.length - 1 || column <= 0) {
            return res;
        }*/
        int left = -10001;
        int right = -10001;
        if (column > 0) {
            left = matrix[raw][column - 1];
        }
        if (raw < matrix.length - 1) {
            right = matrix[raw + 1][column];
            if(right>target){
                return res=false;
            }
        }

        if (left == target || right == target) {
            res = true;
        }
        if (raw < matrix.length - 1) {
            res = judgeIsTrue(matrix, raw + 1, column, target, res);
        }
        if (column > 0&&res==false) {
            res = judgeIsTrue(matrix, raw, column - 1, target, res);
        }
        return res;
    }
}
