package Honetooyoung.大二下.链表.删除排序链表中的重复元素II82;

import Honetooyoung.大二下.common.ListNode;
import Honetooyoung.大二下.common.ListNodeUtil;

class Solution {
    public static void main(String[] args) {
        ListNode head = ListNodeUtil.trans(new int[]{1, 2, 3, 3, 4, 4, 5});
        ListNode listNode = new Solution().deleteDuplicates(head);
        ListNodeUtil.print(listNode);
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}