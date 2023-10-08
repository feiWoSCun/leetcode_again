package feiWoSCun.after20230708.nk.JZ76删除链表中重复的结点;

import feiWoSCun.ListNode;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/8/5
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public static void main(String[] args) {
        List<Integer> asList = Arrays.asList(1, 2, 3, 3, 4, 4, 5);
        ListNode listNode = ListNode.generateListNode(asList);
        Solution s = new Solution();
        ListNode node = s.deleteDuplication(listNode);
    }

    public ListNode deleteDuplication0(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode head1 = new ListNode(0);
        head1.next = pHead;
        ListNode refHead = head1;
        ListNode head2 = pHead;
        while (head2 != null) {
            while (head2 != null && head2.next.val == refHead.next.val) {
                head2 = head2.next;
                if (head2.next == null) {
                    refHead.next = null;
                    return refHead;
                }
                if (head2.next.val != refHead.next.val) {
                    refHead.next = head2.next;
                    head2 = head2.next.next;
                }
            }
            refHead.next = head2;
            refHead = refHead.next;
            head2 = head2.next;
        }
        return head1.next;
    }

    public ListNode deleteDuplication(ListNode pHead) {
        //空链表
        if (pHead == null) {
            return null;
        }
        ListNode res = new ListNode(0);
        //在链表前加一个表头
        res.next = pHead;
        ListNode cur = res;
        while (cur.next != null && cur.next.next != null) {
            //遇到相邻两个节点值相同
            if (cur.next.val == cur.next.next.val) {
                int temp = cur.next.val;
                //将所有相同的都跳过
                while (cur.next != null && cur.next.val == temp) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        //返回时去掉表头
        return res.next;
    }

    public ListNode deleteDuplication1(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode res = new ListNode(0);
        res.next = pHead;
        ListNode toIterator = res;
        while (toIterator.next != null && toIterator.next.next != null) {
            if (toIterator.next.val == toIterator.next.next.val) {
                int val = toIterator.next.val;
                while (toIterator.next != null && toIterator.next.val == val) {
                    toIterator.next = toIterator.next.next;
                }

            } else {
                toIterator = toIterator.next;
            }
        }
        return res.next;
    }
}
