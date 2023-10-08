package feiWoSCun.after20230708.nk.JZ38字符串的排列;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.ForkJoinPool;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/9/7
 * @Email: 2825097536@qq.com
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param str string字符串
     * @return string字符串ArrayList
     */
    ArrayList<String> res = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {

        char[] chars = str.toCharArray();

        Permutation("", chars);
        return res;
    }

    public void Permutation(String str, char[] chars) {
        if (chars.length == 0) {
            res.add(str);
        }
        TreeSet<Character> buffer = new TreeSet<>();
        for (int i = 0; i < chars.length; i++) {
            if(!buffer.contains(chars[i])){
            buffer.add(chars[i]);
            String s = new String(str);
            s += chars[i];
            Permutation(s, deleteFromIndex(chars, i));
            }
        }
    }

    public char[] deleteFromIndex(char[] chars, int index) {
        if (chars.length == 0) {
            return new char[0];
        }
        char[] r = new char[chars.length - 1];
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i == index) {
                continue;
            }
            r[j++] = chars[i];
        }
        return r;
    }
}