package feiWoSCun.after2024.solution;

import feiWoSCun.ListNode;

import java.util.Arrays;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2024/3/19
 * @Email: 2825097536@qq.com
 */

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = ListNode.generateListNode(Arrays.asList(4, 2, 1, 3));
        ListNode listNode1 = solution.sortList(listNode);
        System.out.println();
    }

    public ListNode sortList(ListNode head) {
        return this.merge(head);
    }

    private ListNode merge(ListNode root) {
        if (root == null||root.next==null) {
            return root;
        }
        ListNode s = root;
        ListNode f = root.next;
        //左边
        ListNode l = s;
        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
        }
        //右边
        ListNode r = s.next;
        s.next = null;

        //进行递归
        ListNode rl = this.merge(l);
        ListNode rr = this.merge(r);

        //return 值
        ListNode res = new ListNode(-100001);
        ListNode temp = res;
        while (rl != null && rr != null) {
            if (rr.val > rl.val) {
                res.next = rl;
                rl = rl.next;
            } else {
                res.next = rr;
                rr = rr.next;
            }
            res = res.next;
        }
        if (rr != null) {
            res.next = rr;
        } else {
            res.next = rl;
        }
        return temp.next;
    }
}
