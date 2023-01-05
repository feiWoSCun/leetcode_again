import java.util.Arrays;
import java.util.List;

import javax.sound.midi.Soundbank;

/*
 * @lc app=leetcode.cn id=66 lang=java
 * [66] 加一
 *  时间 2023-01-03 18:34
 *  思路：从低位开始遍历：
 * 1、如果不是9的话，就+1
 *      ·如果上位+1不是9的话，就接着便利下一位
 *          ·返回数组
 *      ·如果上位+1==9的话，就赋值当前位=0
 * 2、退出循环，说明之前遍历的所有位数，全部都是9(如果不是9的话，已经被返回了)
 *      ·那么就令最高位=1,其他位在遍历里面以及被赋值=0了
 *  
 */

// @lc code=start
class Solution1{
    public static int[] plusOne(int[] digits) {
        int len = digits.length - 1;
        for (int i = len; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        // 推出循环，说明所有位数都是9
        //+过后，第一位放1
        int[] ans = new int[digits.length + 1];
        ans[0] = 1;
        return ans;
    }

}
// @lc code=end
