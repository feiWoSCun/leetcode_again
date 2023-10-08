package feiWoSCun.after20230708.nk.JZ69跳台阶;

/**
 * @description: 动态规划
 * @author: feiWoSCun
 * @Time: 2023/9/20
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public int jumpFloor(int number) {
        if (number == 1 || number == 2) {
            return number;
        }
        int first = 1;
        int second = 2;
        int res = 0;
        for (int i = 3; i <= number; i++) {
            res = first + second;
            first = second;
            second = res;
        }
        return res;

    }
}
