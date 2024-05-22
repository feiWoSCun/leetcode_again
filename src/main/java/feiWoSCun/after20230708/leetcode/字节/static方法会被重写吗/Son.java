package feiWoSCun.after20230708.leetcode.字节.static方法会被重写吗;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/12/4
 * @Email: 2825097536@qq.com
 */
public class Son extends Father {
    public static String sayHello(String str) {

        System.out.println(str);
        return str;
    }

}