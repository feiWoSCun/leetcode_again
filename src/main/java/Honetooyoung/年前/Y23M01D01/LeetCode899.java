package Honetooyoung.年前.Y23M01D01;

import java.util.Arrays;

public class LeetCode899 {
    /*给定一个字符串s和一个整数k。你可以从S的前k个字母中选择一个，并把它加到字符串的末尾。
        返回在应用上述步骤的任意数量的移动后，字典上最小1的字符串。*/
}

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.orderlyQueue("xitavoyjqiupzadbdyymyvuteolyeerecnuptghlzsynozeuuvteryojyokpufanyrqqmtgxhyycltlnusyeyyqygwupcaagtkuq", 1);
        System.out.println(s);
    }

    public String orderlyQueue(String s, int k) {
        String ans;
        char[] array = s.toCharArray();
        if (k == 1) {
            int x = 0, i = 0, j = 1;
            int length = array.length;
            while (x < 2 * length && i < length && j < length) {
                char a = array[(i + x) % length], b = array[(j + x) % length];
                if (a == b) {
                    x++;
                } else if (a < b) {
                    j += x + 1;
                    x = 0;
                } else {
                    i = j;
                    j += 1;
                    x = 0;
                }
            }
            ans = s.substring(i) + s.substring(0, i);
        } else {
            Arrays.sort(array);
            ans = String.valueOf(array);
        }
        return ans;
    }
}
