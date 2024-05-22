package feiWoSCun.after2024.hot19;

import feiWoSCun.ListNode;
import feiWoSCun.Util;

import java.util.Arrays;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2024/3/16
 * @Email: 2825097536@qq.com
 */
class Solution {
    public static void main(String[] args) {
        ListNode listNode = ListNode.generateListNode(Arrays.asList(1, 2, 3, 4, 5));
        Solution solution = new Solution();
        ListNode listNode1 = solution.removeNthFromEnd(listNode, 2);

    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root=new ListNode(0);
        root.next=head;
        ListNode temp=root;
        int step=n;
        while(step>0){
            root=root.next;
            step--;
        }
        root=root.next;
        while(root!=null){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        return head;

    }
}