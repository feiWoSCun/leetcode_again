package feiWoSCun.after20230708.leetcode.回文链表;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/12/22
 * @Email: 2825097536@qq.com
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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

import feiWoSCun.ListNode;
import feiWoSCun.some_learn.List;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = ListNode.generateListNode(Arrays.asList(1, 2, 2, 1));
        solution.isPalindrome(listNode);
    }

    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        ListNode fast = head.next.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode rTemp = slow.next;
        //翻转链表
        ListNode r = reverse(rTemp);
        ListNode l = head;
        while (r != null) {
            if (r.val != l.val) {
                return false;
            }
            r = r.next;
            l = l.next;
        }
        return true;
    }

    private ListNode reverse(ListNode node) {
        ListNode p1 = null;
        ListNode p2 = node;
        while (p2 != null) {
            ListNode temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;

        }
        return p1;
    }
}