package feiWoSCun.after20230708.leetcode.全排列;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: {DATE}
 * @Email: 2825097536@qq.com
 */
class Solution {
    public static void main(String[] args) {
        int[] nums=new int[]{1,2,3};
        List<List<Integer>> permute = new Solution().permute(nums);
        System.out.println();
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> inRes = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        test(nums, dp);
        return res;
    }

    private void test(int[] nums, boolean[] dp) {

        for (int i = 0; i < nums.length; i++) {
            if (dp[i]) {
                continue;
            }
            inRes.add(nums[i]);
            dp[i] = true;
            test(nums, dp);
            if(inRes.size()==nums.length)
            deep_copy(res, inRes);
            inRes.remove(inRes.size()-1);
            dp[i] = false;
        }
    }

    private void deep_copy(List<List<Integer>> res, List<Integer> inRes) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < inRes.size(); i++) {
            int j = inRes.get(i);
            temp.add(j);
        }
        res.add(temp);

    }

}