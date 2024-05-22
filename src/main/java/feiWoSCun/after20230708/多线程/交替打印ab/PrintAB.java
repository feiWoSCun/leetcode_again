package feiWoSCun.after20230708.多线程.交替打印ab;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/11/28
 * @Email: 2825097536@qq.com
 */
public class PrintAB extends Thread {
    public static void main(String[] args) {
        PrintAB a = new PrintAB("A", 25, 0);
        PrintAB b = new PrintAB("B", 25, 1);
        b.start();
        a.start();
    }

    private String str;
    private static final Object lock = new Object();
    private static int nums;
    private int self;

    public PrintAB(String str, int nums,int self) {
        this.str = str;
        PrintAB.nums = nums;
        this.self=self;
    }
int printNum=0;
    private void print() {
        while (nums>=printNum) {
            synchronized (lock) {
                while (nums % 2 != self) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(str);
                lock.notifyAll();
            }
            nums++;
        }
    }

    @Override
    public void run() {
        this.print();
    }
}