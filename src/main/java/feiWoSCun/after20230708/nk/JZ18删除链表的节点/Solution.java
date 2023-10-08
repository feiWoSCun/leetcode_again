package feiWoSCun.after20230708.nk.JZ18删除链表的节点;

import feiWoSCun.ListNode;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/8/6
 * @Email: 2825097536@qq.com
 */

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @param val  int整型
     * @return ListNode类
     */
    public ListNode deleteNode(ListNode head, int val) {

        ListNode res = new ListNode(0);
        res.next = head;
        ListNode toIter = res;
        while (toIter.next != null) {
            if (toIter.next.val == val) {
                toIter.next = toIter.next.next;
                break;
            }
            toIter = toIter.next;
        }
        return res.next;
    }
}