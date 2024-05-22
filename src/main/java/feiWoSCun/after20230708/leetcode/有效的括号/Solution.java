package feiWoSCun.after20230708.leetcode.有效的括号;

import java.util.Stack;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/12/7
 * @Email: 2825097536@qq.com
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean valid = solution.isValid("()");
        System.out.println(valid);
    }

    public boolean isValid(String str) {
        Stack<Character> s = new Stack<>();
        char[] c = str.toCharArray();
        for (char ch : c) {
            if (!s.isEmpty() && s.peek() == ch) {
                s.pop();
            } else {
                s.push(ch);
            }
        }
        return s.isEmpty();
    }

    private Character getStr(Character c) {
        switch (c) {
            case ('('):
                return ')';
            case ('['):
                return ']';
            case ('{'):
                return '}';
            default:
                return '0';
        }
    }
}
