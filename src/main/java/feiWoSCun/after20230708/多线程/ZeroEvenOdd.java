package feiWoSCun.after20230708.多线程;

import org.w3c.dom.ls.LSException;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.security.PrivateKey;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.function.IntConsumer;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/10/18
 * @Email: 2825097536@qq.com
 */
public class ZeroEvenOdd {
    private int n;
    ArrayBlockingQueue<Integer> queue0 = new ArrayBlockingQueue<>(1);
    ArrayBlockingQueue<Integer> queue1 = new ArrayBlockingQueue<>(1);
    ArrayBlockingQueue<Integer> queue2 = new ArrayBlockingQueue<>(1);

    private static Object obj = new Object();
    private volatile int now = 0;

    public ZeroEvenOdd(int n) {
        this.n = n;
        queue0.add(1);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (now < n) {
            queue0.take();
            printNumber.accept(0);
            now++;
            if (now % 2 == 0) {
                queue2.put(1);
            } else {
                queue1.put(1);
            }
        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (now <= n) {
            queue2.take();
            printNumber.accept(now);
            queue0.put(1);
            if (now + 2 > n)
                break;
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (now <= n) {
            queue1.take();
            printNumber.accept(now);
            queue0.put(1);
            if (now + 2 > n)
                break;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        final ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(100);
        System.setOut(new PrintStream("feiwoscun.txt"));
        Thread thread1 = new Thread(() -> {
            try {
                zeroEvenOdd.zero(t -> System.out.println(t));

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "打印0");
        Thread thread2 = new Thread(() -> {
            try {
                zeroEvenOdd.even(t -> System.out.println(t));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "打印偶数");
        Thread thread3 = new Thread(() -> {
            try {
                zeroEvenOdd.odd(t -> System.out.println(t));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "打印奇数");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
