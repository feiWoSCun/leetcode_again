package Honetooyoung.大二下.链表.合并两个有序链表21;

import Honetooyoung.大二下.common.ListNode;
import Honetooyoung.大二下.common.ListNodeUtil;

class Solution {
    public static void main(String[] args) {
        ListNode node1 = ListNodeUtil.trans(new int[]{1, 2, 5, 7});
        ListNode node2 = ListNodeUtil.trans(new int[]{1, 3, 7});
        ListNodeUtil.print(new Solution().mergeTwoLists(node1, node2));
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode cur = new ListNode();
        ListNode vir = cur;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                cur = cur.next;
                list1 = list1.next;
            } else {
                cur.next = list2;
                cur = cur.next;
                list2 = list2.next;
            }
        }
        if (list1 != null) cur.next = list1;
        if (list2 != null) cur.next = list2;
        return vir.next;
    }
}