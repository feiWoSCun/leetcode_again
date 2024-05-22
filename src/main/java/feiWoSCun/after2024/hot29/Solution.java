package feiWoSCun.after2024.hot29;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2024/2/5
 * @Email: 2825097536@qq.com
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int divide = solution.divide(10, 3);
        System.out.println(divide);
    }

    public int divide(int dividend, int divisor) {
        boolean isBigThanZero = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);

        long j = (long) divisor;
        long a = j > 0 ? j : -j;
        long under = a;
        long temp = dividend;
        long on = dividend > 0 ? temp : -temp;
        long on1=on;
        if (on < a || on == 0) {
            return 0;
        }
        long res = 0;
        while (on1 >= j) {
            long ans = 1;
            while (under + under <= on1) {
                under += under;
                ans += ans;
            }
            res += ans;
            on1 -= under;
            under = a;
        }
        res = isBigThanZero ? res : -res;
        if (res >= Integer.MAX_VALUE) {
            res = Integer.MAX_VALUE;
        }
        if (res <= Integer.MIN_VALUE) {
            res = Integer.MIN_VALUE;
        }
        return (int) (res);
    }
}
