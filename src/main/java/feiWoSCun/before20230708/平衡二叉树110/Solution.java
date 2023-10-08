package feiWoSCun.before20230708.平衡二叉树110;

import feiWoSCun.TreeNode;

/**
 * @description: n^2
 * @author: feiWoSCun
 * @Time: 2023/5/27
 * @Email: 2825097536@qq.com
 */
public class Solution {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return (Math.abs(calculatedHeight(root.right) - calculatedHeight(root.left)) <= 1) && isBalanced(root.left) && isBalanced(root.right);


    }

    //判断每个节点的最大深度
    private int calculatedHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(calculatedHeight(node.left), calculatedHeight(node.right)) + 1;
    }
}
