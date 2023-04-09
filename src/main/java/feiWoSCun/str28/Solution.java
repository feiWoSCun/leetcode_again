package feiWoSCun.str28;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/4/3
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String str0 = "aaa";
        String str1 = "aaaa";

        int i = solution.strStr(str0, str1);
        System.out.println(i);
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        char[] str0 = haystack.toCharArray();
        char[] str1 = needle.toCharArray();
        int[] next = new int[needle.length()+10];
        //求next数组
        for (int i = 1, j = 0; i < str1.length; i++) {

            while (j > 0 && str1[i] != str1[j]) {
                j = next[j - 1];
            }
            if (str1[i] == str1[j]) {
                next[i] = ++j;
            }

        }
        //匹配
        int b = 0;

        for (int a = 0; a < str0.length; a++) {


            while (b > 0 && str0[a] != str1[b]) {
                b = next[b - 1];
            }

            if (str0[a] == str1[b]) {
                b++;
            }
              if (b == str1.length) {
                return a - b+1;
            }
        }

        return -1;
    }
}
