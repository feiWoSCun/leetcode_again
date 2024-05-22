package feiWoSCun.test;

/**
 * @author: feiWoSCun
 * @Time: 2024/4/11
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 2, 4, 3, 1, 2, 3, 3, 4};
        Solution solution = new Solution();
        int sub = solution.getSub(nums, 9);
        System.out.println(sub);
    }

    /**
     *  * @description: 给定一个含有 n 个正整数的数组和一个正整数 s ，
     *  * 找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。
     *  * 如果不存在符合条件的子数组，返回 0
     * @param nums
     * @param tar
     * @return
     */
    private int getSub(int[] nums,int tar) {
        int p1=0;
        int p2=0;
        int sum=0;
        int res=Integer.MAX_VALUE;
        while(p2<nums.length){
            sum+=nums[p2];
            if(sum>=tar){
                res=Math.min(res,p2-p1+1);
                p1++;
                sum-=nums[p1];
                sum-=nums[p2];
                continue;
            }
            p2++;
        }
        return res;
    }
}