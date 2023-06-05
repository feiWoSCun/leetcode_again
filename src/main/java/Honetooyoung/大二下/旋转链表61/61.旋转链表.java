package Honetooyoung.大二下.旋转链表61;

import Honetooyoung.大二下.common.ListNode;
import Honetooyoung.大二下.common.ListNodeUtil;

class Solution {
    public static void main(String[] args) {
        ListNode node = ListNodeUtil.trans(new int[]{1, 2, 3, 4, 5});
        ListNode res = new Solution().rotateRight(node, 5);
        ListNodeUtil.print(res);
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||k==0){
            return head;
        }
        int count=1;
        ListNode vir=head;
        while (head.next!=null){
            head=head.next;
            count++;
        }
        int x=k%count;
        x=count-x;
        head.next=vir;
        while (x!=0){
            head=head.next;
            x--;
        }
        ListNode ans=head.next;
        head.next=null;
        return ans;
    }
}