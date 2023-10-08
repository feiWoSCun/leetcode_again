package feiWoSCun.after20230708.nk.JZ48最长不含重复字符的子字符串;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/9/23
 * @Email: 2825097536@qq.com
 */

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.lengthOfLongestSubstring("abcabcbb");
        System.out.println(i);
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> temp = new HashMap<>(s.length());
        char[] chars = s.toCharArray();
        int[] dp = new int[s.length() + 1];
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (temp.containsKey(c)) {
                dp[i + 1] = Math.min(dp[i] + 1, i - temp.get(c));
            } else {
                dp[i + 1] = dp[i] + 1;
            }
            res = Math.max(res, dp[i + 1]);
            temp.put(c, i);
        }
        return res;
    }
}
