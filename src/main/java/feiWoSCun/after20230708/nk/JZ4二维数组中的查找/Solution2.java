package feiWoSCun.after20230708.nk.JZ4二维数组中的查找;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/9/7
 * @Email: 2825097536@qq.com
 */
public class Solution2 {
       public boolean Find(int target, int[][] array) {
        int i = 0;
        //行数
        int j = array.length - 1;
        while (i < array[0].length && j >= 0) {
            if (target > array[j][i]) {
                i++;
            } else if (target < array[j][i]) {
                j--;
            } else {
                return true;
            }
        }
        return false;
    }
}
