package feiWoSCun.after20230708.leetcode.字节.走时针;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/12/5
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public static void main(String[] args) {


        Solution solution = new Solution();
      solution.goClock(0, 15);
        System.out.println(ans);
    }

   static int ans;

    public void goClock(int step, int n) {
        if (step == 0 && n == 0) {
            ans += 1;
        }if (step < 0 || n< 0){
            return ;
        }

       goClock(step - 1, n - 1);
        if (step+1==12){
            goClock(0, n - 1);
        }
        goClock(step+1, n - 1);

    }


    public int GetSteps(int n,int step){
        int[][] dp=new int[step+1][n];
        dp[0][0]=1;
        for(int i=1;i<=step;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=dp[i-1][(j-1+n)%n]+dp[i-1][(j+1+n)%n];
            }
        }
        return dp[step][0];
    }
}