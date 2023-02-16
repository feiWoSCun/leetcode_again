import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.lang.model.element.Element;
import javax.print.attribute.Size2DSyntax;

/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        int i1 = 0;
        int m1 = 0;
        int res1 = 0;
        int i2 = 0;
        int m2 = 0;
        int res2 = 0;
        while (null != l1) {
            int ele = l1.val;
            res1 += ele * Math.pow(10, m1);
            m1++;
            l1 = l1.next;
        }

        while (null != l2) {
            int ele = l2.val;
            res2 += ele * Math.pow(10, m2);
            m2++;
            l2 = l2.next;
        }
        res1 = Integer.parseInt(reservInteger(String.valueOf(res1)));
        res2 = Integer.parseInt(reservInteger(String.valueOf(res2)));
        int sum = res1 + res2;

        return getListNode(sum);

    }

    public ListNode getListNode(Integer ele) {
        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        String[] split = ele.toString().split("");
        for (int i = 0; i < split.length; i++) {
            queue.add(Integer.valueOf(split[i]));
        }

        ListNode res = new ListNode();
        while (!queue.isEmpty()) {
            res.next = new ListNode(queue.peek());
            res = res.next;
        }
        return res;
    }

    // 字符串反转
    public String reservInteger(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    };
}
// @lc code=end
