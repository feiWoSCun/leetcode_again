package feiWoSCun.after20230708.leetcode.乘积最大子数组;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/12/23
 * @Email: 2825097536@qq.com
 */
class Solution {
    public static void main(String[] args) {
        boolean res=false;
        boolean ans=false;
        System.out.println(ans|=res);
        int[] nums=new int[]{-1,0,-2,2};
        Solution solution = new Solution();
        int i = solution.maxProduct(nums);
        System.out.println(
                i
        );
    }
    public int maxProduct(int[] nums) {

        int temp=1;
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            temp*=nums[i];
            ans=Math.max(temp,ans);
            if(temp==0){
                temp=1;
                continue;
            }

            int k=1;
            for(int j=0;j<i;j++){
                if(nums[j]==0){
                    continue;
                }
                k*=nums[j];
                int val=temp/k;
                ans=Math.max(ans,val);
            }
        }
        return ans;

    }
}