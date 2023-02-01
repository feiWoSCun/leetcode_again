package Honetooyoung.年前.Y23M01D19;

/*
* 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

子数组 是数组中的一个连续部分。*/
//思路是计算出     每个位置     作为子数组的最后一位      并且和最大的情况      的子数组  的和  放入一个相同长度的数组（int[] dp）  一一对应
//和最大的情况是这样找的：若果 dp[i-1]>0,  则以nums[i]数字作为结尾的子数组最大则是dp[i-1]+nums[i]  因为dp[i-1]是以nums[i-1]为结尾的子数组的最大值，所以加上nums[i]就是nums[i]为结尾的最大值
//如果 dp[i-1]<0 则说明前面    要么是因为加上前一个数，最大和变成了负数     要么是是本身为负数      最大和肯定不会从前面开始 于是就从自己开始 所以dp[i]=nums[i]
//关键就在于dp[i-1]是确定的 来判断dp[i]为什么
class Solution {
    public static void main(String[] args) {
        int[] nums={5,4,-1,7,8};
        System.out.println(new Solution().maxSubArray(nums));
    }
    public int maxSubArray(int[] nums) {
        int ans=nums[0];
        int length=nums.length;
        int[] dp = new int[length];
        dp[0]=nums[0];
        for (int i = 1; i < length; i++) {
            dp[i]=dp[i-1]>0?dp[i-1]+nums[i]:nums[i];
            ans=Math.max(dp[i],ans);
        }
        return ans;
    }
}