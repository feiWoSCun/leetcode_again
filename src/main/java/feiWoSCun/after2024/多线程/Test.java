package feiWoSCun.after2024.多线程;

import java.util.concurrent.*;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2024/1/23
 * @Email: 2825097536@qq.com
 */
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<Integer> callable = () -> 1;
        FutureTask<Integer> task = new FutureTask<>(callable);
        task.run();
        System.out.println(task.get());
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(1)
                , Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        Future<Integer> submit = (Future<Integer>) threadPoolExecutor.<Integer>submit(callable);
        while (!submit.isDone()){
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(submit.isDone());
        System.out.println(submit.get());
    }

}