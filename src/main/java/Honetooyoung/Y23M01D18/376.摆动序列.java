package Honetooyoung.Y23M01D18;

/*
* 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。

    例如，[1, 7, 4, 9, 2, 5] 是一个 摆动序列 ，因为差值 (6, -3, 5, -7, 3)是正负交替出现的。
    相反，[1, 4, 7, 2, 5]和[1, 7, 4, 5, 5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。

子序列 可以通过从原始序列中删除一些（也可以不删除）元素来获得，剩下的元素保持其原始顺序。

给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度 。*/
//思路是记录上一次差值的正负，如果下次相反则结果+1，如果相同则跳过，得出最后的答案+1即可
class Solution {
    public static void main(String[] args) {
        int [] nums={0,0};
        System.out.println(new Solution().wiggleMaxLength(nums));
    }
    public int wiggleMaxLength(int[] nums) {
        int ans=0;
        int flag=0;
        for (int i = 0; i < nums.length-1; i++) {
            int val = nums[i+1] - nums[i];
            if (flag==1 && val<0){
                ans++;
                flag=-1;
                continue;
            }
            if (flag==-1&&val>0){
                ans++;
                flag=1;
                continue;
            }
            if(flag==0){
                if(val>0){
                    flag=1;
                    ans++;
                }
                else if(val<0){
                    flag=-1;
                    ans++;
                }
            }
        }
        return ans+1;
    }
}