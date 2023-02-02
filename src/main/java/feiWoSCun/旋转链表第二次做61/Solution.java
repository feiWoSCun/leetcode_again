package feiWoSCun.旋转链表第二次做61;

import java.util.List;

/**
 * @Description：懂的人自然懂
 * @Author: feiWoSCun
 * @Email: 2825097536@qq.com
 * @Date: 2023-1-25
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/**
 * @author feiwoscun
 */
public class Solution {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);

        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
         listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        Solution solution = new Solution();
        ListNode listNode = solution.rotateRight(listNode1, 2);
        System.out.println();
    }

        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null || k == 0) {
                return head;
            }
            //计算链表的长度
            int num = 1;
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
                num++;
            }
            //整数倍直接返回原链表
            if (k % num == 0) {
                return head;
            }
            //形成环形链表
            temp.next = head;
            //找到断开的位置
          /*  1234 5
                4123*/
            ListNode listNode = head;
            for (int i = 1; i < (num - k % num); i++) {
                listNode = listNode.next;
            }
            ListNode ans = listNode.next;
            listNode.next = null;
            return ans;
        }
}