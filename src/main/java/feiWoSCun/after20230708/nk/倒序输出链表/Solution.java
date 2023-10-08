package feiWoSCun.after20230708.nk.倒序输出链表;


import feiWoSCun.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/7/30
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList arr = new ArrayList();
        if (listNode == null) {
            return arr;
        }
        ListNode node = listNode;

        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        while (!stack.isEmpty()) {
            arr.add(stack.pop());
        }
        return arr;
    }
}