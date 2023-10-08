package feiWoSCun.before20230708.搜索二维矩阵74;

/**
 * @description: 第一种方法超时了，还是用二分吧
 * @author: feiWoSCun
 * @Time: 2023/3/24
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public static void main(String[] args) {
     //  int[][] matrix= {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
       int[][] matrix={{1,3,5}};
        Solution solution = new Solution();
        boolean b = solution.searchMatrix(matrix, 4);
        System.out.println(b);
    }
    public boolean searchMatrix(int[][] matrix, int target) {
//从行出发
        int raw = matrix.length;
        int i = raw;
    while (--i>=0&&matrix[i][0] > target) {

        }
    if(i<0){
        return false;
    }
        //二分
        int left = 0;
        int right = matrix[0].length;
        int middle = 0;
        int temp = -10001;
        while (left < right) {
            middle = left + (right - left) /2;
            temp = matrix[i][middle];
            if (temp == target) {
                return true;
            } else if (temp > target) {
                right = middle;

            } else if (temp < target) {
                left = middle + 1;
            }
        }
        return  false;
    }
}
