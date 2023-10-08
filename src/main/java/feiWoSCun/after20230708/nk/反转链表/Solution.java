package feiWoSCun.after20230708.nk.反转链表;

import feiWoSCun.ListNode;

import java.util.Stack;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/8/2
 * @Email: 2825097536@qq.com
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> res = new Stack<>();
        ListNode tempNode = head;
        while (tempNode != null) {
            res.push(tempNode);
            tempNode=tempNode.next;
        }
        ListNode virtualHeadNode = new ListNode(0);
        ListNode tempNode2 = virtualHeadNode;
        while (!res.isEmpty()) {
            ListNode pop = res.pop();
            tempNode2.next=new ListNode(pop.val);
            tempNode2=tempNode2.next;
        }
        return virtualHeadNode.next;
    }
}