package feiWoSCun.some_learn;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/10/18
 * @Email: 2825097536@qq.com
 */
public class Cat {
    void say_hello() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("feiwoscun");
    }
    protected  void say(){
        System.out.println("feiwoscun");
    }

    public static void main(String[] args) {
        String s="feiwoscun";
        String substring = s.substring(0, 1);
        
        System.out.println(s.substring(0, 1));
    }
}
