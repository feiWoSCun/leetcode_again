import java.util.Arrays;
import java.util.Objects;

/*
 * @lc app=leetcode.cn id=844 lang=java
 *
 * [844] 比较含退格的字符串
 */

// @lc code=start
class Solution {

    public boolean backspaceCompare(String s, String t) {

        String s1 = doublePointer(s);
        String t1 = doublePointer(t);

        return s1.equals(t1);

    }

    public String doublePointer(String str) {
        char[] x = str.toCharArray();
        int slow = 0;
        for (int fast = 0; fast < x.length; fast++) {
            // 当x[fast] != '#'时，x[fast]覆盖x[slow]，然后slow++
            if (x[fast] != '#')
                x[slow++] = x[fast];
            // 当x[fast] = '#'且slow!=0时，slow--
            else if (x[fast] == '#' && slow != 0)
                slow--;
        }

        // 返回字符串
        return String.valueOf(x, 0, slow);
    }

}
// @lc code=end
