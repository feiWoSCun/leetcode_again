package feiWoSCun.after20230708.leetcode.二叉树的层序遍历102;

import feiWoSCun.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 一次过 直接秒了
 * @author: feiWoSCun
 * @Time: {DATE}
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> pre = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();
        pre.add(root);

        while (!pre.isEmpty() || !next.isEmpty()) {
            ArrayList<Integer> inRes = new ArrayList<>();
            while (!pre.isEmpty()) {
                TreeNode node = pre.poll();
                if (node != null) {
                    inRes.add(node.val);
                    TreeNode left = node.left;
                    if (left != null) {
                        next.add(left);
                    }
                    TreeNode right = node.right;
                    if (right != null) {
                        next.add(right);
                    }
                }
            }
            LinkedList<TreeNode> temp = next;
            next=pre;
            pre=temp;
            res.add(inRes);
        }
        return res;
    }
}
