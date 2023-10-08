package feiWoSCun.after20230708.nk.JZ29顺时针打印矩阵;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/10/8
 * @Email: 2825097536@qq.com
 */

import java.util.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5}
;        int rows = 1;
        int cols = 5;
        int[][] matrix = new int[rows][cols];

        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = nums[index++];
            }
        }
////////////
        System.out.println(Arrays.deepToString(matrix));
        Solution solution = new Solution();
        ArrayList<Integer> arrayList = solution.printMatrix(matrix);
        System.out.println();
    }

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        int j = 0;//纵坐标
        int i = 0;//横坐标
        int max_j = matrix[0].length - 1;
        int max_i = matrix.length - 1;
        int min_j = 0;
        int min_i = 0;

        ArrayList<Integer> ans = new ArrayList<>();
        while (!(min_j > max_j || min_i > max_i||max_i<0||max_j<0||min_i>matrix.length-1||max_j>matrix[0].length-1)) {
            while (j <= max_j&&min_j<=matrix[0].length-1) {
                int matrix_j = matrix[i][j++];
                ans.add(matrix_j);
                System.out.println(matrix_j);
            }
            j--;
            i++;
            min_i += 1;
            if(min_i>matrix.length-1){
            break;
            }
            while (i <= max_i) {
                int matrix_i = matrix[i++][j];
                ans.add(matrix_i);
                System.out.println(matrix_i);
            }
            i--;
            j--;
            max_j -= 1;
              if(max_j<0){
            break;
            }
            while (j >= min_j) {
                int matrix_j = matrix[i][j--];
                ans.add(matrix_j);
                System.out.println(matrix_j);
            }
            j++;
            i--;
            max_i -= 1;
            if(max_i<0){
            break;
            }
            while (i >= min_i) {
                int matrix_i = matrix[i--][j];
                ans.add(matrix_i);
                System.out.println(matrix_i);
            }
            i++;
            j++;
            min_j += 1;
        }
        return ans;
    }
}