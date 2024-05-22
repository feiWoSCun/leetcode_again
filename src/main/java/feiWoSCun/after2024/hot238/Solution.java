package feiWoSCun.after2024.hot238;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2024/2/6
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums=new int[]{1,2,3,4};
        int[] ints = solution.productExceptSelf(nums);
        System.out.println(ints);
    }
        public int[] productExceptSelf(int[] nums) {
            int lRes = 1;
            for (int i = 0; i < nums.length; i++) {
                lRes *= nums[i];
            }
            int rRes=1;
            for(int i=nums.length-1;i>=0;i--){
                int temp=nums[i];
                lRes=temp==0?0:lRes/temp;
                nums[i]=lRes*rRes;
                rRes*=temp;

            }
            return nums;
        }
    }