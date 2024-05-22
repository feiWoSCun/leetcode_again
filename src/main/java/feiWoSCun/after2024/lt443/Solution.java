package feiWoSCun.after2024.lt443;

import java.util.ArrayList;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2024/5/4
 * @Email: 2825097536@qq.com
 */
class Solution {
    private static char[] getCharsfromString(String s) {
        String[] split = s.split(",");
        ArrayList<Character> characters = new ArrayList<>();
        for (String string : split) {
            char c = string.charAt(1);
            characters.add(c);
        }
        char[] chars = new char[characters.size()];
        for (int i = 0; i < characters.size(); i++) {
            chars[i] = characters.get(i);
        }
        return chars;
    }

    public static void main(String[] args) {

        String s = "\"a\",\"b\",\"b\",\"b\",\"b\",\"b\",\"b\",\"b\",\"b\",\"b\",\"b\",\"b\",\"b\"";
        int compress = new Solution().compress(getCharsfromString(s));
        new Solution().compress(getCharsfromString(s));
    }

    public int compress(char[] chars) {
        int len = 1;
        int i = 0;
        int j = 1;
        char c = chars[0];
        int index=0;
        while (j < chars.length) {
            int count = 1;
            while (j < chars.length && chars[j] == c) {
                j++;
                count++;
            }

            if (count == 1) {
                len++;
            } else {
                int bit = 0;
                int temp=count;
                while (count != 0) {
                    count /= 10;
                    bit++;
                }
                len += bit;
                while (bit != 0) {
                    int m = temp % 10;
                    chars[index+bit]=Character.forDigit(m,10);
                    temp/=10;
                    bit--;
                }

            }
            c = j < chars.length ? chars[j] : '1';
            index=j;
            j++;
        }
        return len;
    }
}
