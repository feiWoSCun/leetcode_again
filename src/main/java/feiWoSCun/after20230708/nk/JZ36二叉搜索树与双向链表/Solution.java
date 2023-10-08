package feiWoSCun.after20230708.nk.JZ36二叉搜索树与双向链表;

import feiWoSCun.TreeNode;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/8/24
 * @Email: 2825097536@qq.com
 */
public class Solution {
    TreeNode head = null;
    TreeNode pre = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        Convert(pRootOfTree.left);
        if (head == null) {
            head = pRootOfTree;
            pre = pRootOfTree;
        } else {
            pre.right = pRootOfTree;
            pRootOfTree.left = pre;
            pre = pRootOfTree;
        }
        Convert(pRootOfTree.right);
        return head;
    }
}
