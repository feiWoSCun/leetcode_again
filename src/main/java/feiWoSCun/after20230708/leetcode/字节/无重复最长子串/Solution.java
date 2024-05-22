package feiWoSCun.after20230708.leetcode.字节.无重复最长子串;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/12/3
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int s = solution.maxChildrenString("abcabcaaaa");
        System.out.println(s);
    }


    public int maxChildrenString(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        Map<Character, Integer> dp = new HashMap<>(16);
        char[] chars = str.toCharArray();
        int ans = -1;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (dp.containsKey(c) && index <= dp.get(c)) {
                index = dp.get(c)+1;
                dp.put(c, i);
            } else {
                dp.put(c, i);
                ans = Math.max(ans, i - index+1);
            }

        }
        return ans;
    }

}