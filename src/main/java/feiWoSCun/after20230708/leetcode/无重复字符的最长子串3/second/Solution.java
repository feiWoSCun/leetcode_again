package feiWoSCun.after20230708.leetcode.无重复字符的最长子串3.second;

import java.util.HashMap;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/12/13
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> dp = new HashMap<>(16);
        char[] chars = s.toCharArray();
        int index = 0;
        int ans = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (dp.containsKey(c) && index <= dp.get(c)) {
                dp.put(c, i);
                index = dp.get(c);
            } else {
                ans += 1;
            }
            ans = Math.max(ans, dp.get(c) - index + 1);
        }
        return ans;
    }
}