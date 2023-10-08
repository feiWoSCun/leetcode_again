package Honetooyoung.大二下.链表.删除链表中间节点2095;

import Honetooyoung.大二下.common.ListNode;
import Honetooyoung.大二下.common.ListNodeUtil;

class Solution {
    public static void main(String[] args) {
        ListNode node = ListNodeUtil.trans(new int[]{1, 3, 4, 7, 1, 2, 6});
        ListNode ans = new Solution().deleteMiddle2(node);
        ListNodeUtil.print(ans);
    }
    public ListNode deleteMiddle(ListNode head) {
        //快指针（慢指针走一次，快指针走两次）
        ListNode fast=head.next;
        //慢指针
        ListNode slow=head;
        //判断慢指针是否移动
        int count=0;
        //由于是单链表，需要慢指针少走一个以便可以将中间节点的上一个节点指向下一个节点，这里让快指针多走一个
        if(fast==null)
            return null;
        else
            fast=fast.next;
        //移动至末尾
        while (fast!=null){
            fast=fast.next;
            if(count++%2==1)
                slow=slow.next;
        }
        //移除中间节点
        if(slow.next!=null)
            slow.next=slow.next.next;
        return head;
    }
    public ListNode deleteMiddle2(ListNode head) {
        //快指针（慢指针走一次，快指针走两次）
        ListNode fast=head.next;
        //慢指针
        ListNode slow=head;
        //由于是单链表，需要慢指针少走一个以便可以将中间节点的上一个节点指向下一个节点，这里让快指针多走一个
        if(fast==null)
            return null;
        else
            fast=fast.next;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        //移除中间节点
        if(slow.next!=null)
            slow.next=slow.next.next;
        return head;
    }
}