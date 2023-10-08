package feiWoSCun.after20230708.nk.JZ44数字序列中某一位的数字;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/9/20
 * @Email: 2825097536@qq.com
 */

import java.util.*;


public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int nthDigit = solution.findNthDigit(10);
        System.out.println(499999987/8);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param n int整型
     * @return int整型
     */
    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        int i = 1;
        long temp = 0;
             double k;
        while (true) {
             k = Math.pow(10 ,(i - 1));
            temp += (9 * k* i);
            if (temp > n) {
                break;
            } else {
                i++;
            }
        }
        System.out.println(Math.pow(10, (i - 1)));
        int start = (int)Math.pow(10,(i - 1));

        //?为什么要减一：因为temp在计算的时候，第一次少算了一
        int remainder = n - (int)(temp-(9 * k* i))-1;
        int bit = remainder / i;
        System.out.println(bit);
        int mold = remainder % (i);
        while (bit != 0) {
            start++;
            bit--;
        }
        String ans = String.valueOf(start);
        Integer integer = Integer.valueOf(ans.charAt(mold-1));
return integer-48;
    }
}