package feiWoSCun.after20230708.nk.JZ73翻转单词序列;

import java.util.Arrays;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/9/5
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public String ReverseSentence(String str) {
        String[] s = str.split(" ");
        int begin = 0;
        int end = s.length - 1;
        while (begin < end) {
            String temp = s[begin];
            s[begin] = s[end];
            s[end] = temp;
            begin++;
            end--;
        }
        StringBuilder builder = new StringBuilder();
        for (String s1 : s) {
            builder.append(s1);
            builder.append(" ");
        }
        return  builder.substring(0,builder.length()-1);
    }
}
