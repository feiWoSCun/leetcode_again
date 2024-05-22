package feiWoSCun.hot189;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2024/1/31
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public static void main(String[] args) {
        int a=10;
        int b=9;
        a^=b;
        b^=a;
        a^=b;
        System.out.println(a);
        System.out.println(b);
    }
}