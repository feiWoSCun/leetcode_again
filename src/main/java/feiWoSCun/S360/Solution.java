package feiWoSCun.S360;

import java.util.Scanner;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2024/3/23
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public static void main(String[] args) {
        final  int mod=(10^9)+7;
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();
        String s=scanner.next();
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            if (s.charAt(i-1)!='0'){
                dp[i]=dp[i-1];
            }
            int digit=Integer.parseInt(s.substring(i-2,i));
            if (digit>=10&&digit<=26){
                dp[i]=(dp[i]+dp[i-2])%mod;
            }
        }
        System.out.println(dp[n]);
    }

}