package feiWoSCun.after20230708.nk.JZ28对称的二叉树;

import feiWoSCun.TreeNode;

/**
 * @description:
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
    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        } else {
            return compare(pRoot.left, pRoot.right);
        }

    }

    public boolean compare(TreeNode left, TreeNode right) {
        if (left == null) {
            return right == null;
        }
        if (right == null) {
            return false;
        }

        if (left.val == right.val) {
            return false;
        }
        return compare(left.left, right.right) && compare(left.right, right.left);
    }
}
