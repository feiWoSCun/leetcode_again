package feiWoSCun.S360;

import java.util.Scanner;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2024/3/23
 * @Email: 2825097536@qq.com
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        final int mod = (int)1e9 + 7;
        int n=scanner.nextInt();
        String str=scanner.next();
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=str.charAt(0)=='0'?0:1;
        for (int i = 2; i <= n; i++) {
            char cur=str.charAt(i-1);
            char pre=str.charAt(i-2);
            if (cur=='0'){
                if(pre=='1'||pre=='2'){
                    dp[i]=dp[i-2];
                }else{
                    dp[i]=0;
                }
            } else if (cur>='1'&&cur<='6') {
                if (pre=='1'||pre=='2'){
                    dp[i]=(dp[i-1]+dp[i-2])%mod;
                }else {
                    dp[i]=dp[i-1];
                }
            }else {
                if (pre=='1'){
                    dp[i]=(dp[i-1]+dp[i-2])%mod;
                }else{
                    dp[i]=dp[i-1];
                }
            }
        }
        System.out.println(dp[n]);
    }
}