package feiWoSCun.after20230708.leetcode.找到字符串中所有字母异位词438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/12/13
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> anagrams = solution.findAnagrams("cbaebabacd", "abc");
        System.out.println(anagrams);


    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) {
            return res;

        }
        char[] chars = s.toCharArray();
        char[] chars1 = p.toCharArray();
        int[] sDp = new int[26];
        int[] pChars = new int[26];
        int length = p.length();

        for (int i = 0; i < length; i++) {
            pChars[chars1[i] - 'a']++;
            sDp[chars[i] - 'a']++;
        }
        boolean equals = Arrays.equals(sDp, pChars);
        if (equals) {
            res.add(0);
        }
        for (int i = length; i < s.length(); i++) {
            sDp[chars[i - length] - 'a']--;
            sDp[chars[i] - 'a']++;
            if (Arrays.equals(sDp, pChars)) {
                res.add(i-length);
            }
        }
                return res;
    }
}