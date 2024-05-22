package feiWoSCun.after20230708.leetcode.字节.排序链表;

import feiWoSCun.ListNode;

import java.util.Arrays;


/**
 * @description: 二分思想
 * @author: feiWoSCun
 * @Time: 2023/12/2
 * @Email: 2825097536@qq.com
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = solution.sortList(ListNode.generateListNode(Arrays.asList(1, 4, 2, 3)));
        System.out.println(listNode);
    }
    public ListNode sortList(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode first = node;
        ListNode second = node.next;
        ListNode left = first;
        while (second != null && second.next != null) {
            second = second.next.next;
            first = first.next;
        }
        ListNode right = first.next;
        first.next = null;
        ListNode Lhead = sortList(left);
        ListNode RHead = sortList(right);
        ListNode ans = new ListNode(-1);
        ListNode temp=ans;
        ListNode p1 = Lhead;
        ListNode p2 = RHead;
        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                ans.next = p2;
                p2 = p2.next;
            } else {
                ans.next = p1;
                p1 = p1.next;
            }
            ans=ans.next;
        }
        if (p1 != null) {
            ans.next = p1;
        }
        if (p2 != null) {
            ans.next = p2;
        }
        return temp.next;
    }

}