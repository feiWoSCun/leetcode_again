package feiWoSCun.before20230708.两数相加2;

/**
 * @author: feiWoSCun
 * @Time: 2023/2/16
 * @Email: 2825097536@qq.com
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

public class Solution {
    public static void main(String[] args) {

        Solution solution = new Solution();
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        ListNode listNode = solution.addTwoNumbers(listNode1, listNode4);
        System.out.println();

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        getRange(listNode, l1, l2, 0);
        return listNode.next;
    }

    /**
     * @param target 目标结果链表
     * @param l1
     * @param l2
     * @param preNum 上一个需要进位的值
     * @return
     */
    public ListNode getRange(ListNode target, ListNode l1, ListNode l2, int preNum) {
        //走到末尾了 排除空指针
     /*   if (l1 == null) {
            int temp = preNum;
            ListNode listNode = target;
            while (l2 != null) {
                {
                    listNode.next = new ListNode((temp + l2.val) % 10, null);
                    temp = (temp + l2.val) / 10;
                    listNode = listNode.next;
                    l2 = l2.next;
                }
            }
        } else if (l2 == null) {
            int temp = preNum;
            ListNode listNode = target;
            while (l1 != null) {
                {
                    listNode.next = new ListNode((temp + l2.val) % 10, null);
                    temp = (temp + l2.val) / 10;
                    listNode = listNode.next;
                    l2 = l2.next;
                }
            }
        }*/
        //当前位置数字之和
        int i = l1.val + l2.val + preNum;
        int j = i % 10;
        int temp = i /= 10;
        target.next = new ListNode(j);
        if (l1.next == null && l2.next == null) {
            if (temp != 0) target.next.next = new ListNode(temp);
            return target.next.next;
        }
        if (l1.next == null) l1.next = new ListNode(0);
        if (l2.next == null) l2.next = new ListNode(0);
        return getRange(target.next, l1.next, l2.next, temp);
    }
}