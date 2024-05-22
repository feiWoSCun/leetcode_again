package feiWoSCun.after2024.hot560;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2024/1/27
 * @Email: 2825097536@qq.com
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 2,3};

        int i = solution.subarraySum(nums, 3);
        System.out.println(i);
    }
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int[] dp = new int[len + 1];
        int num = 0;
        int res = 0;
        for (int i = 0; i < len; i++) {
            num += nums[i];

            dp[i + 1] = num;
        }

        //dp[i]表示前i个元素的和
        int l=dp.length;
        for (int i = 0; i <l; i++) {
            for (int j = i + 1; j < l; j++) {
                int temp = dp[j] - dp[i];
                if (temp == k) {
                    res += 1;
                }
            }
        }
        return res;
    }

    private void fast_sort() {
    }
}
