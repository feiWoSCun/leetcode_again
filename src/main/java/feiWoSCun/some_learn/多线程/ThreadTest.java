package feiWoSCun.some_learn.多线程;


import java.util.*;

/**
 * @description: 测试创建子线程
 * @author: feiWoSCun
 * @Time: 2024/1/6
 * @Email: 2825097536@qq.com
 */
public class ThreadTest {
    public static void main(String[] args) {
        //个人是这样理解的:
        //子进程在创建的时候会拷贝父进程的变量 ，但是不会进行修改
        //相当是只提供访问的功能；
        //在Java中，lambda函数（也称为Lambda表达式）无法修改值是由于其设计的限制和语义约束。
        //Lambda表达式是一种函数式编程的特性，用于提供简洁的语法来定义匿名函数（函数接口的实现）。Lambda表达式在Java中被广泛用于函数式接口的实现、集合操作和并行编程等场景
        //Java中的Lambda表达式具有以下特点：
        //捕获外部变量：Lambda表达式可以访问外部范围内的变量，但是这些变量必须是隐式最终（effectively final）的，即一旦赋值后不能再修改。
        //限制对外部变量的修改：为了确保线程安全和避免潜在的并发问题，Java的Lambda表达式被设计为不能修改捕获的外部变量。
        //这种限制是为了确保Lambda表达式的可靠性和可预测性。如果允许Lambda表达式修改捕获的外部变量，可能导致多个Lambda表达式之间发生竞争条件，从而引发不确定的结果和难以调试的问题。
        //如果您需要在Lambda表达式中修改变量的值，可以考虑使用可变的容器对象，如数组或集合，或者将变量声明为Atomic类型或volatile类型以支持线程安全的修改操作。
        int i=0;
         final List<String> myList=new ArrayList<>();
        Thread t=new Thread(()->{
            char c='a';

            System.out.println(i);
        });
    }
}