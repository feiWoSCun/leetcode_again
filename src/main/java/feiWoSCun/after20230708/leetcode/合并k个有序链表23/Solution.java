package feiWoSCun.after20230708.leetcode.合并k个有序链表23;

import feiWoSCun.ListNode;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/10/17
 * @Email: 2825097536@qq.com
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        int length = lists.length;
        while (length > 1) {
            int index = 0;
            for (int i = 0; i < length; ) {
                if (i == length - 1) {
                    lists[index++] = lists[i];
                } else {
                    ListNode node = merge_two_linkedNode(lists[i], lists[i + 1]);
                    lists[index++] = node;
                }
                i += 2;
            }
            length = index;
        }
        return lists[0];
    }

    private ListNode merge_two_linkedNode(ListNode list, ListNode list1) {
        //两个指针
        ListNode p = list;
        ListNode p1 = list1;
        //头节点
        ListNode head = new ListNode(-1);
        //当前节点
        ListNode cur = head;
        while (p != null && p1 != null) {
            if (p.val > p1.val) {
                cur.next = p1;
                p1 = p1.next;
            } else {
                cur.next = p;
                p = p.next;
            }
            cur = cur.next;
        }
        if (p1 != null) {
            cur.next = p1;
        } else {
            cur.next = p;
        }
        return head.next;
    }
}