package feiWoSCun.xp;

import java.util.Stack;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2024/4/15
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.ReverseString("fei wosc un"));
    }

    public String ReverseString(String originStr) {
        if (originStr == null || "".equals(originStr)) {
            return originStr;
        }
        StringBuilder sb = new StringBuilder();
        char[] chars = originStr.toCharArray();
        int p1 = 0;
        int p2 = 0;
        while (p2 < chars.length) {
            while (p2!=chars.length&&chars[p2] != ' ') {
                p2++;
            }
            for (int i = p2-1; i >= p1; i--) {
                sb.append(chars[i]);
            }
            if(p2!=chars.length){
                sb.append(' ');
            }
            p2++;
            p1=p2;
        }
        return sb.toString();
    }
}