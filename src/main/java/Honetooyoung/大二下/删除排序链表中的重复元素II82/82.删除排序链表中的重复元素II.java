package Honetooyoung.大二下.删除排序链表中的重复元素II82;

import Honetooyoung.大二下.common.ListNode;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode vir=new ListNode();
        vir.next=head;
        ListNode cur=head;
        ListNode next=head.next;
        while (next.next!=null&&cur.val==next.val){
            int val= cur.val;
            while (val==next.val){
                if(next.next!=null)
                    next=next.next;
                else break;
            }
            if (next.next==null) break;//todo 跳出循环然后呢？
            cur=next;
            next=next.next;
        }
        if(next.next==null&&cur.val==next.val) return null;
        else if (next.next!=null) {
            return cur;
        } else {
            vir.next=cur;
            next=next.next;
            while (next.next!=null&&cur.val==next.val){
                int val= cur.val;
                while (val==next.val){
                    if(next.next!=null)
                        next=next.next;
                    else break;
                }
                if (next.next==null) break;//todo 跳出循环然后呢？
                cur=next;
                next=next.next;
            }
        }

        return vir.next;
    }
}