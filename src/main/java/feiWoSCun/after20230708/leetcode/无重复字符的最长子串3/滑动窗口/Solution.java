package feiWoSCun.after20230708.leetcode.无重复字符的最长子串3.滑动窗口;

import java.util.HashMap;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/11/23
 * @Email: 2825097536@qq.com
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.lengthOfLongestSubstring("tmmzuxt");

    }

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int leftP = -1;
        if (s == null || s.isEmpty()) {
            return 0;
        }
        char[] arr = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>(16);
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (map.containsKey(c)) {
                leftP = Math.max(map.get(c), leftP);
            }else{
                res = Math.max(res, i - leftP);
            }
            map.put(c, i);
        }
        return res;
    }
}