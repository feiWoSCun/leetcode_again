package feiWoSCun.after20230708.leetcode.回文子串020;

import com.sun.tools.javac.Main;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/12/13
 * @Email: 2825097536@qq.com
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.countSubstrings("abc");
        System.out.println(i);
    }
    public int countSubstrings(String s) {
        char[] charArray = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < charArray.length; i++) {
            int l = i - 1;
            int r = i + 1;
            ans++;
            while (l >= 0 && r < charArray.length) {
                if (charArray[l] == charArray[r]) {
                    ans++;
                    l--;
                    r++;
                } else {
                    break;
                }
            }
            int j = i;
            int k = i - 1;
            while (k >= 0 && j < charArray.length) {
                if (charArray[j] == charArray[k]) {
                    ans++;
                    j++;
                    k--;
                } else {
                    break;
                }
            }
        }
        return ans;
    }
}