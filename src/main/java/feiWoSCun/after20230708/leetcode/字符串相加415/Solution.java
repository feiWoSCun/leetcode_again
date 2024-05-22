package feiWoSCun.after20230708.leetcode.字符串相加415;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/10/19
 * @Email: 2825097536@qq.com
 */
class Solution {
    public static void main(String[] args) {
        String s = new Solution().addStrings("408", "5");
        System.out.println(s);
    }

    public String addStrings(String num1, String num2) {
        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();
        int index1 = char1.length - 1;
        int index2 = char2.length - 1;
        int add = 0;
        StringBuilder res_builder = new StringBuilder();
        while (index1 >= 0 && index2 >= 0) {
            int i = char1[index1--] - '0';
            int j = char2[index2--] - '0';
            int res = i + j + add;
            add = res / 10;
            res = res % 10;
            res_builder.insert(0, res);
        }
        if (add != 0) {
            while (add != 0 && index1 >= 0) {
                int i = char1[index1--] - '0';
                i += add;
                add = i / 10;
                res_builder.insert(0, i % 10);
            }
            while (add != 0 && index2 >= 0) {
                int j = char2[index2--] - '0';
                j += add;
                add = j / 10;
                res_builder.insert(0, j % 10);
            }
            if (add != 0) {
                res_builder.insert(0, 1);
            }
        }
        if (index1 >= 0) {
            for (int i = index1; i >= 0; i--) {
                res_builder.insert(0, char1[i]);
            }
        } else if (index2 >= 0) {
            for (int j = index2; j >= 0; j--) {
                res_builder.insert(0, char1[j]);
            }

        }
        return res_builder.toString();
    }
}