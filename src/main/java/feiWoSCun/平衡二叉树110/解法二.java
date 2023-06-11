package feiWoSCun.平衡二叉树110;

import feiWoSCun.TreeNode;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/5/27
 * @Email: 2825097536@qq.com
 */
public class 解法二 {
    public boolean isBalanced(TreeNode root) {

        return calculateHeight(root)  >=0;
    }

    private int calculateHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = calculateHeight(root.left);
        int right = calculateHeight(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }

}
