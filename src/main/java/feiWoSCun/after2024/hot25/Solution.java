package feiWoSCun.after2024.hot25;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2024/2/16
 * @Email: 2825097536@qq.com
 */

import feiWoSCun.ListNode;

import java.util.Arrays;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static void main(String[] args) {
        ListNode listNode = ListNode.generateListNode(Arrays.asList(1, 2, 3, 4, 5));
        Solution s=new Solution();
        ListNode listNode1 = s.reverseKGroup(listNode, 2);
        System.out.println(listNode1.val);

    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre = new ListNode(0);
        ListNode res = pre;
        ListNode begin = head;
        ListNode end = head;
        while (begin != null) {
            int i = k;
            while (i > 1 && end != null) {
                end = end.next;
                i--;
            }
            if (end == null) {
                pre.next=begin;
                break;
            }
            ListNode node1 = end.next;
            pre.next = reverse(begin, end);
            pre = begin;
            begin = node1;
            end=begin;
        }
        ListNode re= res.next;
        return  re;
    }

    private ListNode reverse(ListNode begin, ListNode end) {
        ListNode l = null;
        ListNode r = begin;
        while (l != end) {
            ListNode temp = r.next;
            r.next = l;
            l = r;
            r = temp;
        }
        return end;
    }
}
