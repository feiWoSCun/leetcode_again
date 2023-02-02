package feiWoSCun.排序链表148;

import java.text.BreakIterator;
import java.util.*;

/**
 * @Description：我是水彩笔
 * @Author: feiWoSCun
 * @Email: 2825097536@qq.com
 * @Date: 2023-1-25
 * 时间
 * 23 ms
 * 击败
 * 10.58%
 * 内存
 * 57.6 MB
 * 击败
 * 5.1%
 */

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

class Solution {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(2);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
/*ListNode listNode6=listNode1;
listNode6.next=listNode5;*/


        Solution solution = new Solution();
        ListNode listNode = solution.sortList(listNode1);
    }

    public ListNode sortList(ListNode head) {
        List<Integer> arrayList = new ArrayList<>();
        sortAsLIst(arrayList, head);
        Collections.sort(arrayList);
        ListNode listNode = new ListNode();
        sortMyList(arrayList, listNode, null);
        System.out.println(listNode);
        return null;

     /*   //递归
        ListNode target = new ListNode();
        ListNode sort = sort(target, head);
        return sort;*/
    }

    public void sortAsLIst(List<Integer> arrayList, ListNode listNode) {
        if (listNode == null) {
            return;
        }
        arrayList.add(listNode.val);
        sortAsLIst(arrayList, listNode.next);
    }

    public void sortMyList(List<Integer> arrayList, ListNode listNode, Integer i) {

        if (i == null) {
            i = 0;
        }

        listNode.val = arrayList.get(i);
        i += 1;
        if (i.intValue() == arrayList.size()) {
            return;
        }
        //这里要实例化，不然内存指向有问题
        listNode.next = new ListNode();

        sortMyList(arrayList, listNode.next, i);
        System.out.println(1);
    }


    /*-------------------------------------------------------------------------------------------------------------*/
    public ListNode getSmall(ListNode listNode1) {
        if (listNode1 == null) {
            return null;
        }
       /* if (listNode1.next == null) {
            return listNode2;
        } else if (listNode2.next == null) {
            return listNode1;
        } else if (listNode1.val < listNode2.val) {
            return getSmall(listNode1, listNode2);
        } else {
            return getSmall(listNode1.next, listNode2);*/

        ListNode before = new ListNode(listNode1.val);
        ListNode now = listNode1.next;
        while (true) {
            //退出条件
            if (now == null) {
                break;
            }
            if (before.val > now.val) {
                //更新
                before = now;
            }
            now = now.next;
        }
        return before;

    }

    public ListNode sort(ListNode target, ListNode head) {
        //存储次最小值
        ListNode temp = getSmall(head);
        target = temp;
        ListNode temp1 = head;
        ListNode temp2 = target;
        while (true) {
            //终止条件
            if (temp1 == null) {
                break;
            }
            temp1 = temp1.next;
            temp = getSmall(temp1);

            temp2.next = temp;
            temp2 = temp2.next;
        }

        return target;
       /* if(head.next==null) {
            return ;
        }
        target=getSmall(head);
        return sort(target.next,head.next);*/
    }


    /**
     * 研究一下答案的写法
     */


    /*------------------------------------------------------------------------------------------------------------------------*/



   static class Solution1 {
        public static void main(String[] args) {
            ListNode listNode1 = new ListNode(1);
            ListNode listNode2 = new ListNode(3);
            ListNode listNode3 = new ListNode(3);
            ListNode listNode4 = new ListNode(5);
            ListNode listNode5 = new ListNode(2);

            listNode1.next = listNode2;
            listNode2.next = listNode3;
            listNode3.next = listNode4;
            listNode4.next = listNode5;
/*ListNode listNode6=listNode1;
listNode6.next=listNode5;*/


            Solution1 solution = new Solution1();
            ListNode listNode = solution.sortList(listNode1);
        }
        public ListNode sortList(ListNode head) {
            return sortList(head, null);
        }

        public ListNode sortList(ListNode head, ListNode tail) {
            //头节点是空就直接返回
            if (head == null) {
                return head;
            }
            //只有两个节点的情况需要排除，避免出现空指针
            if (head.next == tail) {
                head.next = null;
                return head;
            }
            //快慢指针。找到中间的节点
            ListNode slow = head, fast = head;
            while (fast != tail) {
                slow = slow.next;
                fast = fast.next;
                if (fast != tail) {
                    fast = fast.next;
                }
            }
            ListNode mid = slow;
            ListNode list1 = sortList(head, mid);
            ListNode list2 = sortList(mid, tail);

            /*-----list1------中间节点-------list2------*/
            ListNode sorted = merge(list1, list2);
            return sorted;
        }

        public ListNode merge(ListNode head1, ListNode head2) {
            ListNode dummyHead = new ListNode(0);
            ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
            while (temp1 != null && temp2 != null) {
                if (temp1.val <= temp2.val) {
                    temp.next = temp1;
                    temp1 = temp1.next;
                } else {
                    temp.next = temp2;
                    temp2 = temp2.next;
                }
                temp = temp.next;
            }
            if (temp1 != null) {
                temp.next = temp1;
            } else if (temp2 != null) {
                temp.next = temp2;
            }
            return dummyHead.next;
        }
    }


}

