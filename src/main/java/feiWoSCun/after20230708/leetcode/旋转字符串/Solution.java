package feiWoSCun.after20230708.leetcode.旋转字符串;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/11/29
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public static void main(String[] args) {
        String[] s1 = "hello  world".split(" ");

        Solution solution = new Solution();
        String s = solution.reverseMessage(" ");
        System.out.println(s);
    }

    public String reverseMessage(String message) {
        if (message == null || "".equals(message)) {
            return message;
        }
        int left = 0;
        int right = message.length() - 1;
        while (right >= 0 && message.charAt(right) == ' ') {
            right--;
        }
        while (left <= message.length() - 1 && message.charAt(left) == ' ') {
            left++;
        }
        int j = right;
        int i = j;
        StringBuilder builder = new StringBuilder();
        if (left > right){
            return "";
        }
        while (j >= left) {
            while (i >= left && message.charAt(i) != ' ') {
                i--;
            }
            builder.append(message.substring(i+1, j+1));
            builder.append(" ");
            while (i >= left && message.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }
        return builder.substring(0,builder.length()-1);
    }
}