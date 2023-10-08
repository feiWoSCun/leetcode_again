package feiWoSCun.after20230708.nk.JZ51数组中的逆序对;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/9/26
 * @Email: 2825097536@qq.com
 */
import java.util.*;




public class Solution {
    public static void main(String[] args) {
        int[] nums=new int[]{1,2,3,2,4,6,89,76,45,342,241,45,6676,245,64,62,134};
        int i = new Solution().InversePairs(nums);
        System.out.println(i);
    }

    private int res=0;
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int InversePairs (int[] nums) {
        merge_sort(nums,0,nums.length-1);
        return res;
        // write code here
    }
    private void merge_sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + ((right - left) /2);
        merge_sort(nums, left, mid);
        merge_sort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }
    private void merge(int nums[], int left, int mid, int right) {
        int temp[] = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            if (nums[p1] <= nums[p2] ) {
                temp[i++] = nums[p1++];
            } else {
                temp[i++] = nums[p2++];
                res+=mid-p1+1;
                res%=1000000007;
            }
        }
        while (p1 <= mid) {
            temp[i++] = nums[p1++];
        }
        while (p2 <= right) {
            temp[i++] = nums[p2++];
        }
        for (int j = 0; j < temp.length; j++) {
            nums[left + j] = temp[j];
        }
    }
}