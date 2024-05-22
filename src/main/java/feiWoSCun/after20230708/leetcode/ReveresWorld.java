package feiWoSCun.after20230708.leetcode;

import java.util.Scanner;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/11/23
 * @Email: 2825097536@qq.com
 */
public class ReveresWorld {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] charArray = s.toCharArray();
        int left = 0;
        int right = 0;
        for (char c : charArray) {
            if ('(' == c) {
                left += 1;
            }
            if (')' == c) {
                right += 1;
            }
        }
        if (right > left) {
            System.out.println("Happy");
        } else if (right == left && right != 0) {
            System.out.println("Just so so");
        } else if (left > right) {
            System.out.println("Sad");
        } else {
            System.out.println("None");

        }
    }

}