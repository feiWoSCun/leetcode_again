package feiWoSCun.after20230708.无重复字符的最长子串3;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/7/8
 * @Email: 2825097536@qq.com
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {

        int left = 0;
        int res = 0;
        HashMap<Character, Integer> cache = new HashMap<>(16);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cache.containsKey(c) && cache.get(c) >= left) {
                res = Math.max(res, i - left);
                left = cache.get(c)+1;
            }
            cache.put(c, i);
        }
        return Math.max(res,s.length()-left);
    }
}