package feiWoSCun.after20230708.nk.JZ44数字序列中某一位的数字;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/9/20
 * @Email: 2825097536@qq.com
 */
public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int nthDigit = solution1.findNthDigit(2799);
        System.out.println(nthDigit);
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param n int整型
     * @return int整型
     */
    //解题思路：https://blog.csdn.net/qq_38196982/article/details/104962098
    public int findNthDigit(int n) {
        // write code here
        if (n < 10) return n;
        //把0位剔除,方便计算
        n--;
        int k = 1;
        int num = 0;
        //计算出n所在的区间，并保存n所在区间的位数
        while (n > 0) {
            num = n;
            n = (int) (n - Math.pow(10, k - 1) * 9 * k);
            k++;
        }
        //a：第几个数，b：数的第几位
        int a = num / (k - 1);
        int b = num % (k - 1);
        //a需要加上区间的基数
        a = a + (int) (Math.pow(10, k - 2));
        String s = a + "";
        //a的第b位数字就是所求的第n位数字
        return Integer.parseInt(s.substring(b, b + 1));
    }
}
