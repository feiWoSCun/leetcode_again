package feiWoSCun.after20230708.nk.JZ52两个链表的第一个公共结点;

import feiWoSCun.ListNode;

import java.util.Stack;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/8/3
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode temp1 = pHead1;
        ListNode temp2 = pHead2;
        Stack<ListNode> c1 = new Stack<>();
        Stack<ListNode> c2 = new Stack<>();
        while (temp1 != null) {
            c1.add(temp1);
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            c2.add(temp2);
            temp2 = temp2.next;
        }
        Stack<ListNode> res = new Stack<>();
        while (!c1.isEmpty() && !c2.isEmpty()) {
            int nodeVal;
            if ((nodeVal = c1.pop().val) == c2.pop().val) {
                res.push(new ListNode(nodeVal));
            } else {
                break;
            }
        }
        ListNode head = new ListNode(1);
        ListNode refHead =head;
        while (!res.isEmpty()) {
            head.next = res.pop();
            head=head.next;
        }
        return refHead.next;
    }

}
