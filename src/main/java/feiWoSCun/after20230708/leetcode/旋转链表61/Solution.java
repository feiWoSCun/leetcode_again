package feiWoSCun.after20230708.leetcode.旋转链表61;

import feiWoSCun.ListNode;
import feiWoSCun.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/11/10
 * @Email: 2825097536@qq.com
 */
class Solution {
    public static void main(String[] args) {
        LinkedList<TreeNode> treeNodes = new LinkedList<>();TreeNode treeNode = treeNodes.pollFirst();
        ListNode listNode = ListNode.generateListNode(Arrays.asList(1, 2));
        ListNode listNode1 = new Solution().rotateRight(listNode, 3);
    }

    public ListNode rotateRight(ListNode head, int  k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        int num=1;
        // tail向前走k%n步
        while (k>0){
            if (tail.next == null) {
                tail = head;
                k--;
                k=k%num;
                continue;
            } else {
                tail = tail.next;
            }
            num++;
            k--;
        }
        // pre和tail同步向前走，直达tail走到表尾
        ListNode pre = head;
        while (tail.next != null) {
            tail = tail.next;
            pre = pre.next;
        }
        // 截断、拼接pre后面的节点至表前
        tail.next = head;
        head = pre.next;
        pre.next = null;
        return head;
    }
}
