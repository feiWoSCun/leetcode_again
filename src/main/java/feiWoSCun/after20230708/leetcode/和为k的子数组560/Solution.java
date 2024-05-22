package feiWoSCun.after20230708.leetcode.和为k的子数组560;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/12/15
 * @Email: 2825097536@qq.com
 */
class Solution {
    public static void main(String[] args) {
        int[] ints = {1, 1, 1};
        Solution solution = new Solution();
        solution.subarraySum(ints,2);
    }
    public int subarraySum(int[] nums, int k) {
        int res=0;
        int[][] dp=new int[nums.length][nums.length];
        for(int i=0;i<nums.length;i++){
            dp[i][i]=nums[i];
            if(nums[i]==k){
                res+=1;
            }
        }

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j>nums.length;j++){
                dp[i][j]=dp[i][j-1]+nums[j];
                if(dp[i][j]== k){
                    res+=1;
                }
            }
        }
        return res;
    }
}