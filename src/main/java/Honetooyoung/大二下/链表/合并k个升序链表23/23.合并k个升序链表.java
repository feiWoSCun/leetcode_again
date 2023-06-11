package Honetooyoung.大二下.链表.合并k个升序链表23;

import Honetooyoung.大二下.common.ListNode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null){
            return new ListNode().next;
        }
        List<ListNode> nodeList = Arrays.stream(lists).collect(Collectors.toList());
        return merge(nodeList);
    }

    private ListNode merge(List<ListNode> nodeList) {
        if (nodeList.size()>1) {
            ListNode listNode = mergeTwoLists(nodeList.get(0), nodeList.get(1));
            nodeList.remove(0);
            nodeList.remove(0);
            nodeList.add(listNode);
            return merge(nodeList);
        }else
            return nodeList.get(0);
    }

    private ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        ListNode head=new ListNode();
        ListNode tail=head;
        while (node1!=null&&node2!=null){
            if (node1.val< node2.val){
                tail.next=node1;
                node1=node1.next;
            }else {
                tail.next=node2;
                node2=node2.next;
            }
            tail=tail.next;
        }
        tail.next=node1==null?node2:node1;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next=new ListNode(4);
        listNode1.next.next=new ListNode(5);
        ListNode listNode2 = new ListNode(1);
        listNode2.next=new ListNode(3);
        listNode2.next.next=new ListNode(4);
        ListNode listNode3 = new ListNode(2);
        listNode3.next=new ListNode(6);
        ListNode[] listNodes={listNode1,listNode2,listNode3};
        ListNode listNode = new Solution().mergeKLists(listNodes);
        System.out.println(listNode);
    }
}