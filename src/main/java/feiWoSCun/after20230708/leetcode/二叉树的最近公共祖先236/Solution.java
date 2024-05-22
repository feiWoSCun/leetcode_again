package feiWoSCun.after20230708.leetcode.二叉树的最近公共祖先236;

import feiWoSCun.TreeNode;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: {DATE}
 * @Email: 2825097536@qq.com
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return ifAncestor(root, p, q);
    }

    private TreeNode ifAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = ifAncestor(root.left, p, q);
        TreeNode right = ifAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        return root;
    }
}