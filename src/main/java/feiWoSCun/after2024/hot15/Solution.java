package feiWoSCun.after2024.hot15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2024/1/21
 * @Email: 2825097536@qq.com
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.threeSum(new int[]{
                -1,0,1,2,-1,-4
        });
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 2; i < nums.length; i++) {
            int tar = -nums[i];
            if(nums[i]==nums[i-1]){
                continue;
            }
            if (tar > 0) {
                continue;
            }
            int l = 0;
            int r = i - 1;
            while (l < r) {
                if (nums[l] > 0) {
                    break;
                }

                int sum = nums[l] + nums[r];
                if (sum == tar) {
                    List<Integer> tr = new ArrayList<>();
                    tr.add(nums[l]);
                    tr.add(nums[r]);
                    tr.add(nums[i]);
                    while (l<r&&nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l<r&&nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                    res.add(tr);
                } else if (sum < tar) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }
}
