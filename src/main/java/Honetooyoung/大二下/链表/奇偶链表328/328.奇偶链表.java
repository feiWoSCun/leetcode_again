package Honetooyoung.大二下.链表.奇偶链表328;

import Honetooyoung.大二下.common.ListNode;
import Honetooyoung.大二下.common.ListNodeUtil;

class Solution {
    public static void main(String[] args) {
        ListNode node = ListNodeUtil.trans(new int[]{});
        ListNode ans = new Solution().oddEvenList(node);
        ListNodeUtil.print(ans);
    }
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        //奇数移动指针
        ListNode odd=head;
        //偶数移动指针
        ListNode even=head.next;
        //奇数链表的头节点
        ListNode tail=head.next;
        while(even!=null&&even.next!=null){
            //奇数节点指向下个奇数节点
            odd.next=odd.next.next;
            //指针移动到下一个节点
            odd=odd.next;
            //偶数节点指向下个偶数节点
            even.next=even.next.next;
            //指针移动到下一个节点
            even=even.next;
        }
        //奇数末节点连接偶数链表的头节点
            odd.next=tail;
        return head;
    }
}