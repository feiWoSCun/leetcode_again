package feiWoSCun.after20230708.leetcode.反转链表二;

import feiWoSCun.ListNode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/10/14
 * @Email: 2825097536@qq.com
 */
class Solution {
    public static void main(String[] args) {
        ListNode listNode = ListNode.generateListNode(Arrays.asList(1, 2, 3, 4, 5));
        ListNode listNode1 = new Solution().reverseBetween(listNode, 2, 4);
        System.out.println();
    }

    public ListNode reverseBetween(ListNode head1, int left, int right) {
        int step = right - left;
        ListNode pre = null;
        ListNode head2 = new ListNode(-1);
        ListNode head=head2;
        head.next = head1;
        while (left >= 2) {
            head = head.next;
            left--;
        }
        ListNode curr = head.next;
        if (curr == null) {
            return curr;
        }
        while (step >= 0) {
            ListNode node = curr.next;
            curr.next = pre;
            pre = curr;
            curr = node;
            step--;
        }
        head.next.next = curr;
        head.next = pre;

        return head2.next;

    }
}