package feiWoSCun.after20230708.leetcode.环形链表二;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: {DATE}
 * @Email: 2825097536@qq.com
 */

import feiWoSCun.ListNode;
import feiWoSCun.Util;

import java.util.Arrays;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public static void main(String[] args) {
        ListNode listNode = ListNode.cycle_list(Arrays.asList(3, 2, 0, 4), 1);
        new Solution().detectCycle(listNode);
    }
    public ListNode detectCycle(ListNode head) {
        ListNode slow =new ListNode(-1);
        slow.next=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null&&slow!=null){
            if(slow==fast){
                ListNode temp=new ListNode(-1);
                temp.next=new ListNode(0);
                temp.next.next=head;
                while(temp!=slow){
                    temp=temp.next;
                    slow=slow.next;
                }
                return slow;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        return null;
    }
}