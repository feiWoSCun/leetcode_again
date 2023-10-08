package feiWoSCun.after20230708.nk.JZ30包含min函数的栈;

import java.util.Arrays;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/9/4
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.push(9);
        solution.push(1);
        solution.push(6);
        solution.min();
        solution.pop();
        solution.pop();
        solution.min();
    }

    private int[] stack = new int[16];
    int nowLength = 0;
    int min = 10001;

    public void push(int node) {
        if (nowLength < stack.length) {
            stack[nowLength++] = node;
        } else {
            this.stack = Arrays.copyOf(stack, stack.length << 1);
            stack[nowLength++] = node;
        }
        min = Math.min(min, node);
    }

    public void pop() {
        if (nowLength <= 0) {
            throw new RuntimeException("长度为0,无法弹栈");
        }
        int[] stackTemp = new int[stack.length];
        System.arraycopy(stack, 0, stackTemp, 0, nowLength - 1);
        int popNum = stack[--nowLength];
        stack = stackTemp;
        if (popNum == min) {
            min = 100001;
            for (int i = 0; i < nowLength; i++) {
             min=Math.min(stack[i],min);
            }
        }
    }

    public int top() {
        return stack[nowLength - 1];
    }

    public int min() {
        return min;
    }
}
