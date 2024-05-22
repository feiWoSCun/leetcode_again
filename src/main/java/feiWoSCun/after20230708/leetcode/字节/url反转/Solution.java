package feiWoSCun.after20230708.leetcode.字节.url反转;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/12/3
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.reverseUrl("www.baidu.com");
        System.out.println(s);
    }

    public String reverseUrl(String url) {
        if (url == null) {
            return null;
        }
        int p1 = url.length()-1;
        int p2 = p1+1;
        StringBuilder builder = new StringBuilder();
        while (p1 >= 0) {
            while (p1 >= 0 && (url.charAt(p1) != '/' && url.charAt(p1) != '.')) {
                p1--;
            }
            if (p1 >= 0 && (url.charAt(p1) == '/' || url.charAt(p1) == '.')) {
                builder.append(url.substring(p1 + 1, p2));
                builder.append(url.charAt(p1));
            }
            if (p1 < 0) {
                builder.append(url.substring(0, p2));
            }

            p2 = p1;
            p1--;
        }
        return builder.toString();
    }
}