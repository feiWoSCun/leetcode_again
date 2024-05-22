package feiWoSCun.some_learn.多线程;

import java.util.concurrent.*;

/**
 * @description:  看一下Future的功能
 * @author: feiWoSCun
 * @Time: 2023/12/29
 * @Email: 2825097536@qq.com
 */
public class MyFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = new ThreadPoolExecutor(2, 4, 30, TimeUnit.MINUTES, new ArrayBlockingQueue<>(12),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 10; i++) {
            Future<Integer> future = pool.submit(() -> {
                for (int j = 0; j < 100; j++) {
                    TimeUnit.MILLISECONDS.sleep(10);
                    System.out.println("sleep");
                }
                return 4;
            });
            future.get();
        }

        System.out.println("blocking......");
    }
}