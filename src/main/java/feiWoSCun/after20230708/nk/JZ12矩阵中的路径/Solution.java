package feiWoSCun.after20230708.nk.JZ12矩阵中的路径;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/9/25
 * @Email: 2825097536@qq.com
 */
import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param matrix char字符型二维数组
     * @param word string字符串
     * @return bool布尔型
     */
    public boolean hasPath (char[][] matrix, String word) {

        char[] str = word.toCharArray();
        // write code here
        int i = matrix.length;
        int j = matrix[0].length;
        for (int m = 0; m < i; m++) {
            for (int n = 0; n < j; n++) {
                boolean ans = judge(str, matrix, 0, m, n);
                if (ans) return ans;
            }
        }
        return false;
    }
    private  boolean judge(char[] str, char[][] matrix, int index, int index1,
                           int index2) {
        if (index1 < 0 || index1 >= matrix.length || index2 < 0 ||
                index2 >= matrix[0].length || matrix[index1][index2] != str[index]) {
            return false;
        }
        if (index == str.length-1) {
            return true;
        }
        char temp = matrix[index1][index2];
        matrix[index1][index2] = '.';
        boolean res= judge(str, matrix, index + 1, index1 + 1, index2) ||
               judge(str, matrix, index + 1, index1 - 1, index2) ||
               judge(str, matrix, index + 1, index1, index2 + 1) ||
               judge(str, matrix, index + 1, index1, index2 - 1);
        matrix[index1][index2] = temp;
        return res;
    }


}