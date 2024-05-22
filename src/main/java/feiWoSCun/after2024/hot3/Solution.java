package feiWoSCun.after2024.hot3;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2024/1/21
 * @Email: 2825097536@qq.com
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String str="tmmzuxt";
        int i = solution.lengthOfLongestSubstring(str);

    }

    public int lengthOfLongestSubstring(String s) {
        int index = -1;
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (map.containsKey(c)) {
                Integer m = map.get(c);
                if (m < index) {} else {
                    index = m;
                }
            }

                res = Math.max(res, i - index);
            map.put(c, i);
        }
        return  res;
    }
}
