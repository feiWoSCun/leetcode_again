package Honetooyoung.Y23M01D07;

public class LiCode1658 {
    /*
    * 给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。

如果可以将 x恰好 减到0 ，返回 最小操作数 ；否则，返回 -1 。*/
}

class Solution {
    public static void main(String[] args) {
        int[] nums = {5,1,4,2,3};
        System.out.println(new Solution().minOperations(nums, 6));
    }

    public int minOperations(int[] nums, int x) {
        int target = -x;
        int ans = nums.length;
        for (int i = 0; i < nums.length; i++) target += nums[i];
        if (target < 0)
            return -1;
        if (target == 0)
            return ans;
        int right = 0, left = 0;
        int temp = 0;
        while (right < nums.length) {
            if (target - temp > 0) {
                temp += nums[right];
                right++;
                continue;
            } else if (target - temp < 0) {
                temp -= nums[left];
                left++;
            } else {
                ans = Math.min(ans, nums.length - right + left);
                temp -= nums[left];
                left++;
            }
        }
        while (target-temp<0){
            temp-=nums[left++];
        }
        if(target - temp == 0)
            ans=Math.min(ans, nums.length - right + left);
        return ans==nums.length?-1:ans;
    }
}