package feiWoSCun.S360;

import java.util.Scanner;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2024/3/23
 * @Email: 2825097536@qq.com
 */
public class Solution3 {
    public static void main(String[] args) {
        final int mod = (int)1e9 + 7;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char[] cs = scanner.next().toCharArray();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = cs[i] - '0';
        }
        n = a.length;
        int[] dp = new int[n + 1];
        dp[0] = dp[1]=1;
        for (int i = 1; i < n; i++) {
            int sum = dp[i];
            if (a[i - 1] == 1 || a[i - 1] == 2 && a[i] < 7) {
                sum = (sum + dp[i - 1]) % mod;
            }
            dp[i + 1] = sum;
        }
        System.out.println(dp[n]);
    }
}