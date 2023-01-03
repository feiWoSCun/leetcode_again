package Honetooyoung.Y23M01D03;

public class LiCode2 {
    /**
     * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
     * <p>
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * <p>
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     */
    static public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int temp = 0;
        ListNode listNode = new ListNode();
        ListNode t = new ListNode(0, listNode);
        while (l1.next != null && l2.next != null) {
            int val = l1.val + l2.val + temp;
            if (val > 9) {
                val -= 10;
                temp = 1;
            } else
                temp = 0;
            if (t.next == null)
                t.next = new ListNode(val);
            else
                t.next.val += val;
            t = t.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        int last = l1.val + l2.val + temp;
        if (last > 9) {
            last -= 10;
            temp = 1;
        } else
            temp = 0;
        if (t.next == null)
            t.next = new ListNode(last);
        else
            t.next.val += last;
        t = t.next;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null) {
            int i = l1.val + temp;
            if (i > 9) {
                i -= 10;
                temp = 1;
            } else
                temp = 0;
            t.next = new ListNode(i);
            t = t.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int i = l2.val + temp;
            if (i > 9) {
                i -= 10;
                temp = 1;
            } else
                temp = 0;
            t.next = new ListNode(i);
            t = t.next;
            l2 = l2.next;
        }
        if (temp > 0) {
            t.next = new ListNode(1);
        }
        return listNode;
    }
//优化算法
    static public ListNode addTwoNumbersPro(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode listNode2 = new ListNode(9, new ListNode(9, new ListNode(6, new ListNode(2))));
        ListNode listNode3 = new ListNode(0);
        ListNode listNode4 = new ListNode(1);
        // ListNode listNode = addTwoNumbers(listNode1, listNode2);
        ListNode listNode5 = addTwoNumbers(listNode3, listNode4);
        // System.out.println(listNode);
    }
}

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



