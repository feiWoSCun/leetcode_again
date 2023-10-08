package feiWoSCun.after20230708.nk.JZ68二叉搜索树的最近公共祖先;

import feiWoSCun.TreeNode;

/**
 * @description: 利用二叉搜索树的性质完成    就不用全部递归了
 * @author: feiWoSCun
 * @Time: 2023/9/4
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public int lowestCommonAncestor(TreeNode root, int p, int q) {
        // write code here
        if (root.val < p && root.val < q) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val > p && root.val > q) {
            return lowestCommonAncestor(root, p, q);
        } else {
            return root.val;
        }
    }
}
