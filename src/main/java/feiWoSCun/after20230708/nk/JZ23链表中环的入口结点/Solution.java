package feiWoSCun.after20230708.nk.JZ23链表中环的入口结点;

import com.sun.source.tree.ReturnTree;
import feiWoSCun.ListNode;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/8/3
 * @Email: 2825097536@qq.com
 */
public class Solution {
    //        nc+l=x
//        slow------>fast=c
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode fastNode = pHead;
        ListNode slowNode = pHead;
        while (fastNode != null && slowNode != null) {
            slowNode = slowNode.next;
            ListNode next = fastNode.next;
            if (next == null) {
                return null;
            }
            fastNode = next.next;
            if (fastNode != null && (fastNode == slowNode)) {
                //在环里的情况  the situation they are in the circle
                ListNode resNode = pHead;
                while (true) {
                    if (resNode == slowNode) {
                        return resNode;
                    }
                    resNode = resNode.next;
                    slowNode = slowNode.next;
                }
            }
        }
        return null;
    }
}
