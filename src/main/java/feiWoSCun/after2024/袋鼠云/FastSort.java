package feiWoSCun.after2024.袋鼠云;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2024/4/11
 * @Email: 2825097536@qq.com
 */
public class FastSort {
    public static void main(String[] args) {

    }
    private void fastSort(int[] nums,int l,int r) {
                int temp=nums[0];
                int left=l;
                int right=r;
                while (l<r){
                    while (nums[right]>=temp){
                        right--;
                    }
                    if(nums[right]<temp){
                        nums[left]=nums[right];
                        left++;
                    }
                }


    }
}