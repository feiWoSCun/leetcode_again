package feiWoSCun.删除排序链表中的重复元素II82;


/**
 * @Description：时间 0 ms 击败 100% 内存 40.7 MB 击败 95.9%
 * @Author: feiWoSCun
 * @Email: 2825097536@qq.com
 * @Date: 2023-1-25
 *
 * 第一次这么牛逼
 * 时间 0 ms 击败 100% 内存 40.7 MB 击败 95.9%
 * 时间 0 ms 击败 100% 内存 40.7 MB 击败 95.9%
 * 时间 0 ms 击败 100% 内存 40.7 MB 击败 95.9%
 * 时间 0 ms 击败 100% 内存 40.7 MB 击败 95.9%
 * 时间 0 ms 击败 100% 内存 40.7 MB 击败 95.9%
 * 时间 0 ms 击败 100% 内存 40.7 MB 击败 95.9%
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        //特殊情况
        if (head == null || head.next == null) {
            return head;
        }
        //快慢指针
        ListNode slow = head;
        ListNode fast = head.next;
        //指向slow变换之前的指针
        ListNode headSlow=slow;
        //结束标志
        while (fast != null) {
            //标志
            boolean a = false;
            //相等，就一直滑动
            while (fast!=null&&fast.val == slow.val) {
                fast = fast.next;
                a = true;
            }
            if (a) {
                //考虑前面一直是一样
                if (slow == head) {
                    slow = fast;
                    head = fast;
                } else {
                    headSlow.next = fast;
                    slow=fast;
                }
            }
            if(!a) {
                headSlow = slow;
            }
            slow=fast;
            //在循环的时候更新了fast 所以需要进行判断
            if(fast==null){
                return head;
            }
            fast = fast.next;
        }
        return head;
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