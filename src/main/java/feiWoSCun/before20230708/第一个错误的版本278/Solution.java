package feiWoSCun.before20230708.第一个错误的版本278;

/**
 * @Description： 煞笔二分法，我日泥仙人板板，明天我一定把你搞懂
 * @Author: feiWoSCun
 * @Email: 2825097536@qq.com
 * @Date: 2023-1-6
 * 0000001111111111
 */
public class Solution extends VersionControl {
    public static void main(String[] args) {
        int i = new Solution().firstBadVersion(4);
        System.out.println(i);
    }

    //00011
    public int firstBadVersion(int n) {
        //二分
        int middle = n >> 1;
        //现在的值
        int head = 0;
        int tail = n;
        while (true) {
            if (isBadVersion(middle) && !isBadVersion(middle - 1)) return middle;
            if (!isBadVersion(middle) && isBadVersion(middle + 1)) return middle + 1;
            //连续两个都是漏洞，就往前走；0000000111(11)1111111
            if (isBadVersion(middle - 1)) {
                tail = middle;
                middle = middle +(middle- head)>>1 ;
                if (middle == tail - 1) return isBadVersion(middle) ? middle : middle + 1;
            }
            //两个都不是漏洞，往后走
            if (!isBadVersion(middle + 1)) {
                head = middle;
                middle = middle+((tail-middle)>>1);
                if (middle - 1 == head) return isBadVersion(middle) ? middle : middle + 1;


            }
        }
    }

    @Override
    public boolean isBadVersion(int version) {
        return version >= 1;
    }
}