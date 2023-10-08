package feiWoSCun.after20230708.nk.JZ9用两个栈实现队列;

import java.util.*;
import java.util.Stack;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/9/4
 * @Email: 2825097536@qq.com
 */
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return  stack2.pop();
        }
    }
}
