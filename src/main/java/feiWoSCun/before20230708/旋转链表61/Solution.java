package feiWoSCun.before20230708.旋转链表61;

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
        // listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        Solution solution = new Solution();
        ListNode listNode = solution.rotateRight(listNode1, 1);
        System.out.println();
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        if (k <= 0) {
            return head;
        }

        //找到目标节点
        ListNode target = head;
        //记录后面的一段链表
        ListNode tail = head;
        while (k != 0) {
            k--;
            if (target.next == null) {
                target = head;
                continue;
            }
            if (k == 0 && target.next.next == null) {
                tail = target.next;
                target.next = null;
                break;
            }
            target = target.next;

            if (k == 0) {
                tail = target.next;
                target.next = null;
            }
        }
        ListNode ans;
        ListNode list = tail;
        while (list.next != null) {
            list = list.next;
        }
        list.next = head;
        ans = tail;
        return ans;
    }
}