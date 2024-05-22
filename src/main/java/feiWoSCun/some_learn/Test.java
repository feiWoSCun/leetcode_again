package feiWoSCun.some_learn;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/10/18
 * @Email: 2825097536@qq.com
 */
public class Test {
    public static final Cat cat = new Cat();

    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);

        Cat cat = new Cat();
//每个线程可以拥有同一个对象，并执行它的方法
        for (int i = 0; i < 20; i++) {
            new Thread(cat::say_hello).start();
        }
    }
}
