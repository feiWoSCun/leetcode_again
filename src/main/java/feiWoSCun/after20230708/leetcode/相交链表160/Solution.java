package feiWoSCun.after20230708.leetcode.相交链表160;

import feiWoSCun.ListNode;
import java.util.Arrays;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/11/1
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public static void main(String[] args) {

        ListNode listNode = ListNode.generateListNode(Arrays.asList(4, 1, 8, 4, 5));
        ListNode pre = listNode;
        pre = pre.next;
        ListNode listNode1 = ListNode.generateListNode(Arrays.asList(5, 6));
        listNode1.next.next = pre;
        ListNode intersectionNode = new Solution().getIntersectionNode(listNode, listNode1);
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        if (headA == headB) {
            return headA;
        }
        ListNode left = getIntersectionNode(headA.next, headB);
        ListNode right = getIntersectionNode(headA, headB.next);
        if (left != null) {
            return left;        } else if (right != null) {
            return right;
        }
        return null;
    }


}

/**
 * heada   headb
 * 4, 5
 * 1,5
 * 8,5
 * 4,5
 * 5,5
 * -----
 * 5,6
 * 5,1
 * 5,8,
 * 5,4
 * 5,5
 */