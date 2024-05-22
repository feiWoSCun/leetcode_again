package feiWoSCun.after20230708.leetcode.queue_to_stack;


import java.util.*;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/11/28
 * @Email: 2825097536@qq.com
 */
public class QueueToStack<E> {
    public static void main(String[] args) {
        QueueToStack<Integer> stack = new QueueToStack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        System.out.println(stack.poll());
        System.out.println(stack.poll());
        System.out.println(stack.getMin());
    }

    private final Queue<E> first = new LinkedList<>();
    private final Queue<E> second = new LinkedList<>();
    private  Object[] array = new Object[16];
    int size = -1;

    public void add(E e) {
        first.offer(e);
        size++;
        array[size] = e;
        //todo 检查扩容
    }

    public E poll() {
        if (size == -1) {
            throw new RuntimeException("还没有添加元素");
        }
        for (int i = 0; i < size; i++) {
            second.offer(first.poll());
        }
        return second.poll();
    }

    public E getMin() {
        //做一个排序
        return (E) array[0];
    }
}