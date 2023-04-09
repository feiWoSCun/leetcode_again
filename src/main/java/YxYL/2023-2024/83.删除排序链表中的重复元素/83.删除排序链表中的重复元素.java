import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * 
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，
 * 使每个元素只出现一次 。返回 已排序的链表 。
 * 
 * 示例 1：
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * 
 * 示例 2：
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)// 如果说当前node == null 或者 下一个node == null 就返回
            return head;
        // 递归获得当前node之后的链表
        head.next = deleteDuplicates(head.next);
        // 判断头节点是否去重
        // 如果头节点的val == next节点的val的话
        // 就返回next节点
        // 否则就返回当前头节点
        return head.val == head.next.val ? head.next : head;
    }
}
// @lc code=end
