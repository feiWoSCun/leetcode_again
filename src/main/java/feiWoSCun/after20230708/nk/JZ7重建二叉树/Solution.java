package feiWoSCun.after20230708.nk.JZ7重建二叉树;

import feiWoSCun.TreeNode;

import java.util.Arrays;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/8/19
 * @Email: 2825097536@qq.com
 */

public class Solution {
    // root index = 1
    // 先序遍历：[1,2,4,7,3,5,6,8]
    // 中序遍历：[4,7,2,1,5,3,8,6]
    // 具体思路是：先通过先序遍历的特点找到跟节点，然后通过跟节点来找到根节点在
    // 中序遍历中的位置，然后根据中序遍历的特点(左根右)，root左边的就是左子树的个数
    // root右边的就是右子树的个数，根据这个特点来通过本方法找到root.left，root.right
    // 再通过递归，找到每一个节点。

    /**
     * Definition for binary tree
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] vin) {
        return dfs(0, 0, vin.length - 1, pre, vin);
    }

    public TreeNode dfs(int preStart, int vinStart, int vinEnd,
                        int[] preOrder, int[] vinOrder) {
        //元素为空//位置不对
        if (preStart > preOrder.length - 1 || vinStart > vinEnd) {
            return null;
        }
        //从先序遍历首元素构建结点
        TreeNode root = new TreeNode(preOrder[preStart]);
        int index = 0;
        //查找中序遍历结果位置
        for (int i = vinStart; i <= vinEnd; i++) {
            if (vinOrder[i] == root.val) {
                index = i;
                break;
            }
        }
        //左结点为先序下一个结点,且该节点位于index左侧
        root.left = dfs(preStart + 1, vinStart, index - 1, preOrder, vinOrder);
        //右结点先序位置为当前结点先序位置+(当前结点左子树数量(当前中序位置-中序开始位置)+当前结点)
        root.right = dfs(preStart + index - vinStart + 1, index + 1, vinEnd, preOrder, vinOrder);
        return root;

    }


    public TreeNode reConstructBinaryTree1(int[] pre, int[] vin) {
        return dfs1(0, 0, vin.length - 1, pre, vin);
    }

    private TreeNode dfs1(int preOrder, int inStart, int inEnd, int[] pre, int[] vin) {
        if (preOrder > pre.length - 1 || inStart > inEnd) {
            return null;
        }
        int j = pre[preOrder];
        TreeNode node = new TreeNode(j);
        int index = 0;
        //注意遍历边界
        for (int i = inStart; i <=inEnd; i++) {
            if (j == vin[i]) {
                index = i;
                break;
            }
        }
        node.left = dfs1(preOrder + 1, inStart, index - 1, pre, vin);
        node.right = dfs1(preOrder + index - inStart + 1, index + 1, inEnd, pre, vin);
        return node;
    }
}