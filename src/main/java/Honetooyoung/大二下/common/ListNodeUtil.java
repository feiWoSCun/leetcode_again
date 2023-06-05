package Honetooyoung.大二下.common;

public class ListNodeUtil {
    public static ListNode trans(int[] arr){
        ListNode listNode = new ListNode();
        ListNode head = listNode;
        for (int i : arr) {
            listNode.next=new ListNode();
            listNode = listNode.next;
            listNode.val = i;
        }
        return head.next;
    }
    public static void print(ListNode head){
        while(head!=null){
            System.out.print(head.val+"  ");
            head=head.next;
        }
    }

    public static void main(String[] args) {
        ListNode node = trans(new int[]{3, 2, 1, 4, 5});
        while(node!=null){
            System.out.print(node.val+"  ");
            node=node.next;
        }
    }
}
