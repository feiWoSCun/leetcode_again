package feiWoSCun.after20230708.leetcode.合并两个有序链表21;

import feiWoSCun.ListNode;

/**
 * @description: 秒杀
 * @author: feiWoSCun
 * @Time: 2023/10/16
 * @Email: 2825097536@qq.com
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode node1 = list1;
        ListNode node2 = list2;
        ListNode cur = head;
        while (node1 != null && node2 != null) {
            if (node1.val > node2.val) {
                cur.next = node2;
                node2 = node2.next;
            } else {
                cur.next = node1;
                node1 = node1.next;
            }
            cur = cur.next;
        }
        if (node1 == null) {
            cur.next = node2;
        } else {
            cur.next = node1;
        }
        return head.next;
    }
}