package feiWoSCun.after2024.hot79;

import feiWoSCun.Util;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2024/2/19
 * @Email: 2825097536@qq.com
 */
class Solution {
    public static void main(String[] args) {
        char[][] twoDArray = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        Solution solution = new Solution();
        boolean see = solution.exist(twoDArray, "SEE");
    }

    public boolean exist(char[][] board, String word) {
        int i = board.length;
        int j = board[0].length;
        char[] chars = word.toCharArray();
        boolean res = false;
        for (int m = 0; m < i; m++) {
            for (int n = 0; n < j; n++) {
                System.out.println(n);
                res = res || backTracing(board, chars, m, n, 0,new boolean[i][j]);
            }
        }
        return res;
    }

    private boolean backTracing(char[][] board, char[] chars, int i, int j, int index,boolean[][] dp) {
        if (index == chars.length) {
            return true;
        }
        if (!ifIn(board, i, j) || board[i][j] != chars[index]||dp[i][j]) {

            dp[i][j]=false;
            return false;
        }
        dp[i][j]=true;
        return (
                backTracing(board, chars, i + 1, j, index + 1,dp) ||
                        backTracing(board, chars, i - 1, j, index + 1,dp) ||
                        backTracing(board, chars, i, j + 1, index + 1,dp) ||
                        backTracing(board, chars, i, j - 1, index + 1,dp)
        );
    }

    private boolean ifIn(char[][] board, int i, int j) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }
}
