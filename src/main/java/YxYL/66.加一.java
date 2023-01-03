import java.util.Arrays;
import java.util.List;

import javax.sound.midi.Soundbank;

/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
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
