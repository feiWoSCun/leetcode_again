package feiWoSCun.分隔链表86;

/**
 * @Description：查到第一个比他大的值node 遍历，把所有的比x大的值放到第一个的前面
 * @Author: feiWoSCun
 * @Email: 2825097536@qq.com
 * @Date: 2023-1-26
 *
 * 时间 0 ms 击败 100% 内存 41.5 MB 击败5.8%
 */
public class Solution {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(2);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        /*ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(1);
        listNode1.next = listNode2;*/
        Solution solution = new Solution();
        solution.partition(listNode1, 3);
        System.out.println();

    }

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        //找到第一个比他大的值的位置node
        ListNode headNode = new ListNode(-255, head);
        ListNode list = headNode;
        while (list.next != null) {
            if (list.next.val >= x) {
                break;
            }
            list = list.next;
        }
        if(list.next==null){
            return headNode.next;
        }
        //节点指向更新的位置
        ListNode listNode = list;
        ListNode nextNode = listNode.next;
        //节点指向遍历的位置
        ListNode nowLocation = list.next;
        while (nowLocation.next != null) {
            //更新链表
            if (nowLocation.next.val < x) {
                //拼接1
                list.next = nowLocation.next;
                ListNode temp = nowLocation.next.next;
                // 12
                list.next.next = nextNode;
                // 124
                list = list.next;
                // 24
                //nextNode = list.next.next;
                nowLocation.next = temp;
            } else {
                nowLocation = nowLocation.next;
            }
        }
        return headNode.next;
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
