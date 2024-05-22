package feiWoSCun.S360;

import com.sun.tools.javac.Main;
import feiWoSCun.SortUtil;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2024/3/23
 * @Email: 2825097536@qq.com
 */
public class Solution4 {
    public static void main(String[] args) {        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String str = scanner.next();
            StringBuilder sb = new StringBuilder(str);
            boolean flag = false;
            for (int j = 0; j <= sb.length(); j++) {
                for (int k = 0; k <= 9; k++) {
                    sb.insert(j, k);
                    String[] split = sb.toString().split("=");
                    if (cal(split[0]) == cal(split[i])) {
                        flag = true;
                        break;
                    }
                    sb.deleteCharAt(j);
                }
                if (flag) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static int cal(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char pre = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                if (pre == '+') {
                    stack.push(num);
                } else if (pre == '-') {
                    stack.push(-num);
                } else if (pre == '*') {
                    stack.push(stack.pop() * num);
                } else {
                    stack.push(stack.pop() / num);
                }
                pre = s.charAt(i);
                num = 0;
            }
        }
            int ans = 0;
            while (!stack.isEmpty()) {
                ans += stack.pop();
            }
            return ans;
        }

}