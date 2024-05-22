package feiWoSCun.some_learn.exception;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/11/7
 * @Email: 2825097536@qq.com
 */
public class Test {

    public void test()   {
        throw new AssertionError("wer");
    }

    void test1() {
        test();
    }
}