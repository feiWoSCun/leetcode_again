package Honetooyoung.大二下.链表.K个一组翻转链表25;

import Honetooyoung.大二下.common.ListNode;
import Honetooyoung.大二下.common.ListNodeUtil;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static void main(String[] args) {
        ListNode node = ListNodeUtil.trans(new int[]{2, 1, 4, 3, 5});
        System.out.println(Integer.MAX_VALUE);
        System.out.println(new Solution().reverseKGroup(node, 2));
    }

    /*
     * */
    public ListNode reverseKGroup(ListNode head, int k) {
        //虚拟头节点vir
        ListNode vir = new ListNode();
        vir.next = head;
        //start为每次即将翻转一段链表的头节点的上一个
        ListNode start = vir;
        //end为每次即将翻转一段链表的头节点的上一个
        //记录
        ListNode end = vir;
        while (end.next != null) {
            //让end走到第k个节点
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            //说明已经不满k个节点了，后面的不反转了，跳出循环
            if (end == null) {
                break;
            }
            //即将翻转的k段链表的第一个节点
            ListNode pre = start.next;
            //记录还未反转的链表de第一个节点
            ListNode next = end.next;
            //让传入reverse函数里的pre节点只有要反转的k个节点
            end.next = null;
            //让已翻转的链表的最后一个节点连接刚进行翻转完成的链表的头节点
            start.next = reverse2(pre);
            //让刚进行翻转完成的链表的最后一个节点连接还未翻转的的链表
            pre.next = next;
            //让end和start重新初始为待反转的链表的上一个节点
            start = pre;
            end = start;
        }
        //返回虚拟头结点的下一个节点
        return vir.next;
    }

    private ListNode reverse(ListNode head) {
        //上一个节点
        ListNode pre = null;
        //当前节点
        ListNode curr = head;
        while (curr != null) {
            //现将下一个节点保存下来(包含后面的节点)
            ListNode next = curr.next;
            //让点前节点指向上一个节点
            curr.next = pre;
            //蒋pre赋值为当前节点
            pre = curr;
            //curr赋值为下一个节点
            curr = next;
        }
        return pre;
    }
    private ListNode reverse2(ListNode head) {
        ListNode next;
        ListNode pre=head;
        while (head.next!=null){
            //存放后续节点链表
            next= head.next;
            //将当前节点指向下下一个节点
            head.next=next.next;
            //将下一个节点指向当前节点
            next.next=pre;
            //让next变为pre
            pre=next;
        }
        return pre;
    }
    private static ListNode reverseList(ListNode head) {
        ListNode end;
        ListNode start = head;
        //end:2 head:k start:1
        end = start.next;
        //1接k+1
        start.next = head.next;

        while (end != head) {
            end.next = start;
            start = end;
            end = end.next;
        }
        head.next = end;
        return end;
    }
    /*  //ptr:2 head:k headNode:1
        end=start.next;
        //1接k+1
        start.next=head.next;


        //2接1
        end.next=start;


        //3接2
        start=end;
        end=end.next;
        //end:3
        end.next=start;

        //4接3
        start=end;
        end=end.next;
        end.next=start;

        head.next=end;*/
}