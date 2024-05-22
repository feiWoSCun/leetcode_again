package feiWoSCun.after20230708.leetcode.和为k的子数组560.second;

import java.util.HashMap;
import java.util.HashSet;
import java.util.zip.Adler32;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/12/15
 * @Email: 2825097536@qq.com
 */
public class Solution {

    public static void main(String[] args) {


    }

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            count+=temp;
            if (map.containsKey(count-k) ) {
                res += map.get(count-k);
            }
            map.put(count, map.getOrDefault(count, 0) + 1);
        }
        return res;
    }

}