package feiWoSCun.after20230708.nk.JZ8二叉树的下一个结点;

import feiWoSCun.TreeNode;
import feiWoSCun.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/9/3
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode node = Util.transferToTreenode(Arrays.asList(5, 4, null, 3, null, 2));
    }
    List<TreeLinkNode> res = new ArrayList<>();
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode temp = pNode;
        while (temp.next != null) {
            temp = temp.next;
        }
        InOrder(temp);
        for (int i = 0; i < res.size()-1; i++) {
            if (res.get(i) == pNode) {
                return res.get(i + 1);
            }
        }
        return null;
    }
    public void InOrder(TreeLinkNode pNode) {
        if (pNode == null) {
            return ;
        }
        InOrder(pNode.left);
        res.add(pNode);
        InOrder(pNode.right);
    }
}
 class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
