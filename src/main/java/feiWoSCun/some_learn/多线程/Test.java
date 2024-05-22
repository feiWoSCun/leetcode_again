package feiWoSCun.some_learn.多线程;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.FutureTask;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/12/30
 * @Email: 2825097536@qq.com
 */
public class Test {
    public static void main(String[] args) {
        FutureTask<Integer> futureTask=new FutureTask<>(() -> 1);
        CompletableFuture<Integer> completableFuture=new CompletableFuture<>();


    }

}