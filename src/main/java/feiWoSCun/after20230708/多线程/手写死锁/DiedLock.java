package feiWoSCun.after20230708.多线程.手写死锁;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/11/28
 * @Email: 2825097536@qq.com
 */
public class DiedLock {

    public static void main(String[] args) {
        DiedLock diedLock = new DiedLock();
        new Thread(diedLock::test1).start();
        new Thread(diedLock::test2).start();
        System.out.println("111111");
    }

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void test1() {
        synchronized (lock1) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (lock2) {
                int a = 1;
            }
        }
    }

    public void test2() {
        synchronized (lock2) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("死锁诞生");
            //lock.notifyAll();
            synchronized (lock1) {
                int b = 0;
            }
        }
    }

    ;


}