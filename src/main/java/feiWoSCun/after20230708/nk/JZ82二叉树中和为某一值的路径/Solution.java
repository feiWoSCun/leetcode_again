package feiWoSCun.after20230708.nk.JZ82二叉树中和为某一值的路径;

import feiWoSCun.TreeNode;
import org.w3c.dom.Node;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/8/24
 * @Email: 2825097536@qq.com
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @param sum  int整型
     * @return bool布尔型
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return hasPathSum1(root, 0, sum);
    }

    private boolean hasPathSum1(TreeNode node, int nowNum, int target) {
        if (node == null) {
            return false;
        }
        nowNum+=node.val;
        if (node.left == node.right) {
            if (nowNum == target) {
                return true;
            }
            return false;
        }

        return hasPathSum1(node.left, nowNum , target) ||
                hasPathSum1(node.right,nowNum, target);
    }
}