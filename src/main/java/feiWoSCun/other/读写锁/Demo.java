package feiWoSCun.other.读写锁;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2024/2/3
 * @Email: 2825097536@qq.com
 */
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Demo {
    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private static int sharedData = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread writerThread = new Thread(() -> {
            lock.writeLock().lock(); // 获取写锁
            try {
                System.out.println("Writer thread is writing data");
                sharedData++; // 修改共享数据
                Thread.sleep(100); // 模拟写操作耗时
                System.out.println("Writer thread finished writing");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.writeLock().unlock(); // 释放写锁
            }
        });

        Thread readerThread = new Thread(() -> {
            lock.readLock().lock(); // 获取读锁
            try {
                System.out.println("Reader thread is reading data: " + sharedData); // 读取共享数据
                Thread.sleep(5000); // 模拟读操作耗时
                System.out.println("Reader thread finished reading");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.readLock().unlock(); // 释放读锁
            }
        });
        readerThread.start();
        TimeUnit.SECONDS.sleep(1);
        writerThread.start(); // 启动写线程
       // 启动读线程

        try {
            writerThread.join(); // 等待写线程执行完毕
            readerThread.join(); // 等待读线程执行完毕
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}