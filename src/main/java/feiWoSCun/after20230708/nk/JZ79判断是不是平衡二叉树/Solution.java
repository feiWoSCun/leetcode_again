package feiWoSCun.after20230708.nk.JZ79判断是不是平衡二叉树;

import com.sun.source.tree.Tree;
import feiWoSCun.TreeNode;

/**
 * @description:输入一棵节点数为 n 二叉树，判断该二叉树是否是平衡二叉树。
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 * 平衡二叉树（Balanced Binary Tree），具有以下性质：它是一棵空树或它的左右两个子树的高
 * 度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
 * @author: feiWoSCun
 * @Time: 2023/9/3
 * @Email: 2825097536@qq.com
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param pRoot TreeNode类
     * @return bool布尔型
     */
    public boolean IsBalanced_Solution(TreeNode pRoot) {
        return getDepth(pRoot) != -1;
    }


    int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int lDepth = getDepth(node.left);
        if (lDepth == -1) {
            return -1;
        }
        int rDepth = getDepth(node.right);
        if (rDepth == -1) {
            return -1;
        }
        if (rDepth - lDepth > 1 || lDepth - rDepth > -1) {
            return -1;
        }
        return Math.max(lDepth, rDepth) + 1;

    }
}
