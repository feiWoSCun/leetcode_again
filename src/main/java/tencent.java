import java.util.ArrayList;
import java.util.Scanner;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2024/4/12
 * @Email: 2825097536@qq.com
 */
public class tencent {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        int num = 0;
        long i = 0;
        long j = 0;
        while (sca.hasNext()) {
            num++;
            i = j;
            j = sca.nextLong();
        }
        if (num < 2) {
            System.out.println(-1);
        }
        System.out.println(getNum(i, j));
    }

    public static long getNum(long a, long b) {
        if (a < b) {
            return getNum(b, a);
        }
        if (b == 0) {
            return a;
        }
        return getNum(b, a % b);
    }
}