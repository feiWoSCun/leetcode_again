package feiWoSCun.before20230708.爬楼梯70;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/4/18
 * @Email: 2825097536@qq.com
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.climbStairs(10);
        System.out.println(i);
    }
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] pre = new int[n + 1];
        int p = 1;
        int q = 2;
        pre[p] = 1;
        pre[q] = 2;
        int i = 3;
        int res = 0;
        while (i <= n) {
            res = pre[p] + pre[q];
            p = q;
            q = q + 1;
            i += 1;
            pre[q]=res;
        }
        return res;
    }
}