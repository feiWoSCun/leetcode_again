package feiWoSCun.after20230708.nk;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/9/22
 * @Email: 2825097536@qq.com
 */
public class MyThread extends  Thread{

    @Override
    public void run() {
        System.out.println("nihao");
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread = new Thread(() -> System.out.println());
        myThread.start();
    }
}
