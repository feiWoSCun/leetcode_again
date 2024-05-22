package feiWoSCun;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/7/30
 * @Email: 2825097536@qq.com
 */
public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    /**
     * 生成链表的工具类 接受一个lis集合
     *
     * @param arr
     * @return
     */
    public static ListNode generateListNode(List<Integer> arr) {
        ListNode head = new ListNode(0);
        ListNode tempNode = head;
        for (Integer integer : arr) {
            tempNode.next = new ListNode(integer);
            tempNode = tempNode.next;

        }
        return head.next;

    }

    public static void main(String[] args) {
        ListNode listNode = generateListNode(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 7, 8, 9));
        System.out.println();
        ListNode listNode1 = cycle_list(Arrays.asList(3, 2, 0, 4), 1);
        System.out.println();
    }

    public static ListNode cycle_list(List<Integer> arr, int index) {
        if (arr != null && index > arr.size() - 1) {
            throw new RuntimeException();
        }
        index = index + 1;
        ListNode listNode = ListNode.generateListNode(Arrays.asList(3, 2, 0, 4));
        ListNode node = new ListNode(0);
        node.next = listNode;
        while (index != 0) {
            node = node.next;
            index--;
        }
        ListNode temp;
        temp = listNode;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        return listNode;
    }


}
