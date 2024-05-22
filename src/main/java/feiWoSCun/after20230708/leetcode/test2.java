package feiWoSCun.after20230708.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/11/23
 * @Email: 2825097536@qq.com
 */
public class test2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int[] nums = new int[i];
        for (int k = 0; k < i; k++) {

            for (int j = 0; j < 6; j++) {
                String s = scanner.next();
                nums[k] = Math.max(nums[k], Integer.parseInt(s));
            }
        }
        Arrays.sort(nums);

        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < nums.length; j++) {
            builder.append(nums[j]);

        }
        System.out.println(builder.reverse());
    }


}