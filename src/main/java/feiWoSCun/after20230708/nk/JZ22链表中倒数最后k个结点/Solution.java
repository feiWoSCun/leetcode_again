package feiWoSCun.after20230708.nk.JZ22链表中倒数最后k个结点;

import feiWoSCun.ListNode;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/8/4
 * @Email: 2825097536@qq.com
 */
public class Solution {

    public ListNode FindKthToTail(ListNode pHead, int k) {
        // write code here
        if (pHead == null) {
            return null;
        }
        ListNode virtualHead = new ListNode(0);
        virtualHead.next = pHead;

        ListNode tempNode2 = virtualHead;
        ListNode tempNode1 = virtualHead;
        for (int i = 0; i < k; i++) {
            tempNode2 = virtualHead.next;
        }
        //两个指针已经准备好了
        while (tempNode2.next != null) {
            tempNode2 = tempNode2.next;
            tempNode1 = tempNode1.next;
        }
        tempNode1.next = tempNode1.next.next;
        return virtualHead.next;
    }
}
