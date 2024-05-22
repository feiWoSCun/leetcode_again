package feiWoSCun.after20230708.nk.JZ55二叉树的深度;

import feiWoSCun.TreeNode;
import feiWoSCun.Util;

import java.util.Arrays;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/8/6
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = Util.transferToTreenode(Arrays.asList(1, 2, 3, 4, 5, null, 6, null, null, 7));
        int i = solution.TreeDepth(treeNode);
        System.out.println(i);
    }

    public int TreeDepth(TreeNode root) {
        return getDepth(root, 0);
    }

    public int getDepth(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }
        depth = Math.max(getDepth(node.left, depth + 1), getDepth(node.right, depth + 1));
        return depth;
    }


}
