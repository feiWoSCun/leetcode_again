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
public class Demo2 {
  final static ReadWriteLock rwl=new ReentrantReadWriteLock();

    public static void main(String[] args)  throws  Exception{
        Thread t1=new Thread(()->{
            rwl.readLock().lock();
            try {
                System.out.println(Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            rwl.readLock().unlock();
        });
        Thread t2=new Thread(()->{
            rwl.readLock().lock();
            try {
                System.out.println(Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        Thread t3=new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            rwl.writeLock().lock();
            System.out.println("获得写锁");
            rwl.writeLock().unlock();
        },"写锁");
        t3.start();
        t2.start();
        t1.start();

    }
}