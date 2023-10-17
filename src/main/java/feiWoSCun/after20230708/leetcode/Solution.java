package feiWoSCun.after20230708.leetcode;

import feiWoSCun.ListNode;
import feiWoSCun.TreeNode;
import feiWoSCun.Util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/10/14
 * @Email: 2825097536@qq.com
 */
class Solution {

    public static void main(String[] args) {
        ListNode node = ListNode.generateListNode(Arrays.asList(1, 2, 3, 4, 5));
        ListNode listNode = new Solution().reverseList(node);
        System.out.println();
    }

    public ListNode reverseList(ListNode head1) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        if (head1 == null) {
            return head.next;
        }
        Stack<Integer> s = new Stack<>();
        ListNode pre = head1;
        while (pre != null) {
            s.push(pre.val);
            pre = pre.next;
        }

        while (!s.isEmpty()) {
            temp.next = new ListNode(s.pop());
            temp = temp.next;
        }
        return head.next;
    }
}