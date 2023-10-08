package feiWoSCun.after20230708.nk.JZ31栈的压入弹出序列;

import java.util.Stack;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/9/5
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public boolean IsPopOrder(int[] pushV, int[] popV) {
        // write code here
        Stack<Integer> s1 = new Stack<>();
        //Stack<Integer> s2 = new Stack<>();
        int j=0;
        for (int i = 0; i < pushV.length; i++) {
            s1.push(pushV[i]);
            while (!s1.isEmpty() && s1.peek() == popV[j]) {
                s1.pop();
                j++;
            }
        }
        return s1.isEmpty();
    }

}
