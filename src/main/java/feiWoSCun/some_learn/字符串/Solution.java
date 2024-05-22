package feiWoSCun.some_learn.字符串;

import java.util.ArrayList;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2024/1/19
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public static void main(String[] args) {

        String s1="feiwoscun";
         String s2="feiwoscun";
         String s3=new String("feiwoscun");
        System.out.println(s3.intern()==s2);//true
        System.out.println(s3==s2);//false
        System.out.println(s1==s2);//true
    }

}