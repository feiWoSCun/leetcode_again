package feiWoSCun.before20230708.按序打印1114;

import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/4/9
 * @Email: 2825097536@qq.com
 */
class Solution {

    private CountDownLatch first = new CountDownLatch(1);
    private CountDownLatch second = new CountDownLatch(1);

    public Solution() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.

        printFirst.run();
        first.countDown();


    }

    public void second(Runnable printSecond) throws InterruptedException {
        first.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        second.countDown();

    }

    public void third(Runnable printThird) throws InterruptedException {
        second.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();


    }
}