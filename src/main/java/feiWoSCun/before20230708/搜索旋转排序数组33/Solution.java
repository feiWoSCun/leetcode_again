package feiWoSCun.before20230708.搜索旋转排序数组33;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/4/9
 * @Email: 2825097536@qq.com
 */
class Solution {
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int middle=0;
        //终止条件
        while(left<=right){


            middle=left+(right-left)/2;
          if(nums[middle]==target){
              return middle;
          }
          int temp=nums[middle];
            if(nums[0]>temp)
            {//在右侧
              if(target>nums[middle]&&target<=nums[right]){
                     left=middle+1;
                }
                else{
                    right=middle-1;
                }
                }
            else{
                if(target<nums[middle]&&target>=nums[left]){
                    right=middle-1
                    ;
                }
                else{
                    left=middle+1;
                }
            }



        }
        return -1;
        //从中间分开

        //选择从一边开始二分

        //另一边开始


    }
}