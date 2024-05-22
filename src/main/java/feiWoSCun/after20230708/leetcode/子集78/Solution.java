package feiWoSCun.after20230708.leetcode.子集78;

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
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> permute = new Solution().permute(nums);
        System.out.println();
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> inRes = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        test(nums, 0);
        return res;
    }

    private void test(int[] nums, int j) {

        for (int i = j; i < nums.length; i++) {

            inRes.add(nums[i]);
            deep_copy(res,inRes);
            test(nums, i + 1);
            inRes.remove(inRes.size() - 1);
        }
    }
private void deep_copy(List<List<Integer>> res,List<Integer> inRes){
    ArrayList<Integer> temp = new ArrayList<>();
    for (int i = 0; i < inRes.size(); i++) {
        int j= inRes.get(i);
        temp.add(j);
    }
        res.add(temp);

}


}