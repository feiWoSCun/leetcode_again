package feiWoSCun.other.读写锁;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2024/2/3
 * @Email: 2825097536@qq.com
 */
public class Solution {

    ReadWriteLock rwl = new ReentrantReadWriteLock();

    void test() {
        rwl.readLock().lock();
        try {
            TimeUnit.SECONDS.sleep(2);

            String name = Thread.currentThread().getName();
            System.out.println(name + "获得了读锁");
            if ("线程1".equals(name)) {
                rwl.readLock().unlock();
                rwl.writeLock().lock();
                System.out.println("线程1获得写锁");

            }
            if ("线程2".equals(Thread.currentThread().getName())) {
                TimeUnit.SECONDS.sleep(2);
            }
            System.out.println(name + "线程打印");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            rwl.readLock().unlock();
        }

    }

    void test2() {
    }

    public static void main(String[] args) {
/*        Solution solution = new Solution();
        Thread t1 = new Thread(() -> {
            solution.test();
        }, "线程1");
        Thread t2 = new Thread(() -> {
            solution.test();
        }, "线程2");
        t2.start();
        t1.start();
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        Solution solution = new Solution();

       final int[] ints = new int[10000];
        for (int i = 0; i < 10000; i++) {
            final  int j=i;
            Runnable r = () -> {
                solution.rwl.readLock().lock();
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                ints[j]=1;
                solution.rwl.readLock().unlock();
            };
            Thread thread = new Thread(r);
            thread.start();
        }
        solution.rwl.writeLock().lock();
        for (int i = 0; i < ints.length; i++) {
            if(ints[i]==0){
                System.out.println("尼玛");
            }
        }
    }

}