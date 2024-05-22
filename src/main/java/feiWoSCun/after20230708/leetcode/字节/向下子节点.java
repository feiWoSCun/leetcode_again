package feiWoSCun.after20230708.leetcode.字节;

import feiWoSCun.ListNode;
import feiWoSCun.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/12/6
 * @Email: 2825097536@qq.com
 */
public class 向下子节点 {
    public static void main(String[] args) {

    }

    public boolean ifSubNode(ListNode list, TreeNode node) {

        if (list == null) {
            return true;
        }
        if (list.val != node.val) {
            return false;
        }
        return ifSubNode(list.next, node.left) || ifSubNode(list.next, node.right);
    }

}