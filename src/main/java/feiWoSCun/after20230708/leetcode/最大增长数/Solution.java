package feiWoSCun.after20230708.leetcode.最大增长数;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/12/5
 * @Email: 2825097536@qq.com
 */
public class Solution {

    public int getMaxIncrease(int num) {
        if (num < 10) {
            return num;
        }
        char[] charArray = String.valueOf(num).toCharArray();
        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] >= charArray[i - 1]) {
                continue;
            } else {
                int n = i - 1;
                for (; n > 0; n--) {
                    if (charArray[n] < charArray[n - 1]) {
                        break;
                    }
                }
                charArray[n - 1] -= 1;
                for (int j = i; j < charArray.length; j++) {
                    charArray[j] = '9';
                }
                break;
            }

        }
        return Integer.parseInt(new String(charArray));
    }

    public static void main(String[] args) {
        int maxIncrease = new Solution().getMaxIncrease(232);
        System.out.println(maxIncrease);
    }
}