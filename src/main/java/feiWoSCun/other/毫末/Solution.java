package feiWoSCun.other.毫末;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/12/21
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public static void main(String[] args) {



    }

    public  void fastSort(int[] nums,int left,int right){
        if(left>=right){
            return;
        }
        int l=left;
        int r=right;
        int temp=nums[left];
        while (l<r){
            while (nums[r]>=temp&&l<r){
                r--;
            }
            if(nums[r]<temp&&l<r){
                nums[l]=nums[r];
                l++;
            }
            while (nums[l]<=temp&&l<r){
                l++;
            }
            if(nums[l]>temp&&l<r){
                nums[r]=nums[l];
                r--;
            }
            //交换
            nums[l]=temp;
        }
        fastSort(nums,left,l);
        fastSort(nums,l+1,right);
    }

}