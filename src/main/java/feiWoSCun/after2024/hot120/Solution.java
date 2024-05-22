package feiWoSCun.after2024.hot120;

import feiWoSCun.Util;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2024/2/24
 * @Email: 2825097536@qq.com
 */
class Solution {
    private final int length=200;
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp=new int[length][length];
        int outLen=triangle.size();
        for(int i=0;i<length;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        dp[0][0]=triangle.get(0).get(0);
        int res=dp[0][0];
        for(int i=0;i<outLen-1;i++){
            for(int j=0;j<i+1;j++){
                Integer l=triangle.get(i+1).get(j);
                Integer r=triangle.get(i+1).get(j+1);
                dp[i+1][j]=Math.min(dp[i][j]+l,dp[i+1][j]);
                dp[i+1][j+1]=Math.min(dp[i][j]+r,dp[i+1][j+1]);
                res=Math.min(dp[i+1][j+1],dp[i+1][j]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minimumTotal(Util.parseString("[[2],[3,4],[6,5,7],[4,1,8,3]]"));


        CountDownLatch countDownLatch=new CountDownLatch(12);



    }
}