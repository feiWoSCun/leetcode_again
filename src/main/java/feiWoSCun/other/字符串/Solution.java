package feiWoSCun.other.字符串;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2024/2/19
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public static void main(String[] args) {
   StringBuilder stringBuilder=new StringBuilder("feiwoscun");
   stringBuilder.deleteCharAt(stringBuilder.length()-1);
        System.out.println(stringBuilder.toString());
    }
}